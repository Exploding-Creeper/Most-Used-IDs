package com.mystic.muid.helper.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.io.IOException;

@Mod.EventBusSubscriber
public class DebugInfoEvent {

    @SubscribeEvent()
    @SideOnly(Side.CLIENT)
    public static void RenderGameOverlayEvent(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            event.getRight().add("Number of Biome IDs Registered: " + ForgeRegistries.BIOMES.getKeys().size());
            event.getRight().add("Number of Block IDs Registered: " + ForgeRegistries.BLOCKS.getKeys().size());
            event.getRight().add("Number of Item IDs Registered: " + ForgeRegistries.ITEMS.getKeys().size());
            event.getRight().add("Number of Potion IDs Registered: " + ForgeRegistries.POTIONS.getKeys().size());
            event.getRight().add("Number of Enchantment IDs Registered: " + ForgeRegistries.ENCHANTMENTS.getKeys().size());
            event.getRight().add("Number of Entity IDs Registered: " + ForgeRegistries.ENTITIES.getKeys().size());
        }
    }

    public static void deleteFile(){

    }

    public static void createFile(){
        File myObj = new File("MUIDoutput.txt");
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
