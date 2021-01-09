package com.mystic.muid.command;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Function;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

import net.fabricmc.loader.FabricLoader;

public class DebugInfoCommand implements Command<ServerCommandSource> {

	private static final DebugInfoCommand CMD = new DebugInfoCommand();

	public static ArgumentBuilder<ServerCommandSource, ?> register(CommandDispatcher<ServerCommandSource> dispatcher) {
		return CommandManager.literal("moddebuginfo")
				.requires(cs -> cs.hasPermissionLevel(3))
				.executes(CMD);
	}

	@Override
	public int run(CommandContext<ServerCommandSource> context){

		try {

			String lineFromInput1 = " ";

			boolean append = false;
			PrintStream out = new PrintStream(new FileOutputStream("MUIDoutput.txt", append));
			System.setOut(out);

			FabricLoader.INSTANCE.getMods().stream().map(modContainer -> modContainer.getMetadata().getId()).forEach(modid -> {
				Function<Registry<?>, Integer> registryCount = registery -> Math.toIntExact(registery.getIds().stream().filter(resourceLocation -> resourceLocation.toString().contains(modid)).count());
				out.println(lineFromInput1);
				out.println(modid);
				int a = registryCount.apply(BuiltinRegistries.BIOME);
				int b = registryCount.apply(Registry.BLOCK);
				int c = registryCount.apply(Registry.ITEM);
				int d = registryCount.apply(Registry.POTION);
				int e = registryCount.apply(Registry.ENCHANTMENT);
				int f = registryCount.apply(Registry.BLOCK_ENTITY_TYPE);
				int g = registryCount.apply(Registry.ENTITY_TYPE);

				if (a > 0) {
					out.println("Number of Biome IDs Registered: " + a);
				}
				if (b > 0) {
					out.println("Number of Block IDs Registered: " + b);
				}
				if (c > 0) {
					out.println("Number of Item IDs Registered: " + c);
				}
				if (d > 0) {
					out.println("Number of Potion IDs Registered: " + d);
				}
				if (e > 0) {
					out.println("Number of Enchantment IDs Registered: " + e);
				}
				if (f > 0) {
					out.println("Number of Tile Entity IDs Registered: " + f);
				}
				if (g > 0) {
					out.println("Number of Entity IDs Registered: " + g);
				}
			});

			//close the file (VERY IMPORTANT!)
			out.close();

			context.getSource().sendFeedback(new LiteralText("Mod Debug File Written :)"), false);

		} catch (IOException e) {
			System.out.println("Error during reading/writing");
			e.printStackTrace();
		}
		return 0;
	}
}