package com.mystic.muid.command;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class DebugInfoCommand extends CommandBase
{

    @Override
    public String getName() {
        return "moddebuginfo";
    }

    public int getRequiredPermissionLevel()
    {
        return 3;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.moddebuginfo.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        List<ModContainer> mods = Loader.instance().getModList();

        try {


            String lineFromInput1 = " ";

            boolean append = false;
            PrintStream out = new PrintStream(new FileOutputStream("MUIDoutput.txt", append));
            System.setOut(out);

            mods.forEach((modContainer -> {
                int a = 0;
                for (ResourceLocation resourceLocation : Biome.REGISTRY.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        a++;
                    }
                }
                int b = 0;
                for (ResourceLocation resourceLocation : Block.REGISTRY.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        b++;
                    }
                }
                int c = 0;
                for (ResourceLocation resourceLocation : Item.REGISTRY.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        c++;
                    }
                }
                int d = 0;
                for (ResourceLocation resourceLocation : Potion.REGISTRY.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        d++;
                    }
                }
                int e = 0;
                for (ResourceLocation resourceLocation : Enchantment.REGISTRY.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        e++;
                    }
                }
                int f = 0;
                for (ResourceLocation resourceLocation : ForgeRegistries.ENTITIES.getKeys()) {
                    if (resourceLocation.toString().contains(modContainer.getModId())) {
                        f++;
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
                    out.println("Number of Entity IDs Registered: " + f);
                }
            }));

            //close the file (VERY IMPORTANT!)
            out.close();

            notifyCommandListener(sender, this, "Mod Debug File Written :)");
        } catch (IOException e) {
            System.out.println("Error during reading/writing");
            e.printStackTrace();
        }
    }
}
