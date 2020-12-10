package com.mystic.muid.helper.event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.util.datafix.TypeReferences.BIOME;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class DebugInfoEvent {
    @SubscribeEvent
    public static void RenderGameOverlayEvent(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getInstance().gameSettings.showDebugInfo) {
            event.getRight().add("Number of Block IDs Registered: " + Registry.BLOCK.keySet().size());
            event.getRight().add("Number of Item IDs Registered: " + Registry.ITEM.keySet().size());
            event.getRight().add("Number of Potion IDs Registered: " + Registry.POTION.keySet().size());
            event.getRight().add("Number of Enchantment IDs Registered: " + Registry.ENCHANTMENT.keySet().size());
            event.getRight().add("Number of Fluid IDs Registered: " + Registry.FLUID.keySet().size());
            event.getRight().add("Number of Effect IDs Registered: " + Registry.EFFECTS.keySet().size());
        }
    }
}
