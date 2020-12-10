package com.mystic.muid.helper.events;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;



@Mod.EventBusSubscriber(Side.CLIENT)
public class DebugInfoEvent {
    @SubscribeEvent
    public static void RenderGameOverlayEvent(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            event.getRight().add("Number of Biome IDs Registered: " + Biome.REGISTRY.getKeys().size());
            event.getRight().add("Number of Dimension IDs Registered: " + DimensionManager.getIDs().length);
            event.getRight().add("Number of Block IDs Registered: " + Block.REGISTRY.getKeys().size());
            event.getRight().add("Number of Item IDs Registered: " + Item.REGISTRY.getKeys().size());
            event.getRight().add("Number of Potion IDs Registered: " + Potion.REGISTRY.getKeys().size());
            event.getRight().add("Number of Enchantment IDs Registered: " + Enchantment.REGISTRY.getKeys().size());
        }
    }
}
