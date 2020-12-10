package com.mystic.muid.helper.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class DebugInfoEvent{

    @SubscribeEvent
    public static void RenderGameOverlayEvent(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getInstance().gameSettings.showDebugInfo) {
            event.getRight().add("Number of Biome IDs Registered: " + ForgeRegistries.BIOMES.getKeys().size());
            event.getRight().add("Number of Block IDs Registered: " + ForgeRegistries.BLOCKS.getKeys().size());
            event.getRight().add("Number of Item IDs Registered: " + ForgeRegistries.ITEMS.getKeys().size());
            event.getRight().add("Number of Potion IDs Registered: " + ForgeRegistries.POTIONS.getKeys().size());
            event.getRight().add("Number of Enchantment IDs Registered: " + ForgeRegistries.ENCHANTMENTS.getKeys().size());
            event.getRight().add("Number of Fluid IDs Registered: " + ForgeRegistries.FLUIDS.getKeys().size());
            event.getRight().add("Number of Tile Entities IDs Registered: " + ForgeRegistries.TILE_ENTITIES.getKeys().size());
            event.getRight().add("Number of Entity IDs Registered: " + ForgeRegistries.ENTITIES.getKeys().size());
        }
    }
}
