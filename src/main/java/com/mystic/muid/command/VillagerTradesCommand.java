package com.mystic.muid.command;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class VillagerTradesCommand extends CommandBase
{
    @Override
    public String getName() {
        return "villagertradinginfo";
    }

    public int getRequiredPermissionLevel()
    {
        return 3;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.villagertradinginfo.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        try {
            String lineFromInput1 = " ";
            PrintStream out = new PrintStream(new FileOutputStream("VillagerTradingInfo.txt", false));
            System.setOut(out);

            World world = server.getEntityWorld();

            for (Entity entity : world.loadedEntityList) {
                if (entity instanceof EntityVillager) {
                    EntityVillager villager = (EntityVillager) entity;
                    MerchantRecipeList tradeList = villager.getRecipes(null); // Get the trade list

                    // Iterate through the trades offered by the villager
                    for (MerchantRecipe trade : tradeList) {
                        // You can access trade information like this:
                        ItemStack buyItem1 = trade.getItemToBuy();
                        ItemStack buyItem2 = trade.getSecondItemToBuy();
                        ItemStack sellItem = trade.getItemToSell();
                        int maxUses = trade.getMaxTradeUses();
                        int uses = trade.getToolUses();

                        // Do something with the trade information
                        out.println(lineFromInput1);
                        out.println(villager.getName());
                        out.println("Buy Item 1: " + buyItem1);
                        out.println("Buy Item 2: " + buyItem2);
                        out.println("Sell Item: " + sellItem);
                        out.println("Max Uses: " + maxUses);
                        out.println("Uses: " + uses);
                        out.println(lineFromInput1);
                    }
                }
            }

            //close the file (VERY IMPORTANT!)
            out.close();

            notifyCommandListener(sender, this, "Villager Trading Info File Written :)");
        } catch (IOException e) {
            System.out.println("Error during reading/writing");
            e.printStackTrace();
        }
    }
}
