package com.mystic.muid.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class DebugInfoCommand implements Command<CommandSource> {

    private static final DebugInfoCommand CMD = new DebugInfoCommand();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("moddebuginfo")
                .requires(cs -> cs.hasPermissionLevel(3))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context){

        try {

            String lineFromInput1 = " ";

            boolean append = false;
            PrintStream out = new PrintStream(new FileOutputStream("MUIDoutput.txt", append));
            System.setOut(out);

            ModList.get().getMods().forEach((modContainer -> {

                int a = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.BIOMES.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        a++;
                    }
                }
                int b = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.BLOCKS.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        b++;
                    }
                }
                int c = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.ITEMS.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        c++;
                    }
                }
                int d = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.POTIONS.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        d++;
                    }
                }
                int e = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.ENCHANTMENTS.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        e++;
                    }
                }
                int f = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.TILE_ENTITIES.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        f++;
                    }
                }
                int g = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.ENTITIES.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        g++;
                    }
                }

                out.println(lineFromInput1);
                out.println(modContainer.getModId());

                if(a > 0){
                    out.println("Number of Biome IDs Registered: " + a);
                }
                if(b > 0){
                    out.println("Number of Block IDs Registered: " + b);
                }
                if(c > 0){
                    out.println("Number of Item IDs Registered: " + c);
                }
                if(d > 0){
                    out.println("Number of Potion IDs Registered: " + d);
                }
                if(e > 0){
                    out.println("Number of Enchantment IDs Registered: " + e);
                }
                if(f > 0){
                    out.println("Number of Tile Entity IDs Registered: " + f);
                }
                if(g > 0){
                    out.println("Number of Entity IDs Registered: " + g);
                }
            }));

            //close the file (VERY IMPORTANT!)
            out.close();

            context.getSource().sendFeedback(new TranslationTextComponent("Mod Debug File Written :)"), false);

        } catch (IOException e) {
            System.out.println("Error during reading/writing");
            e.printStackTrace();
        }
        return 0;
    }
}
