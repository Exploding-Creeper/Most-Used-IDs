package com.mystic.muid.event;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class DebugInfoEvent implements HudRenderCallback {

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        if (MinecraftClient.getInstance().options.debugEnabled) {
            TextRenderer tr = MinecraftClient.getInstance().textRenderer;

            List<String> lines = new ArrayList<>();
            lines.add("Number of Biome IDs Registered: " + BuiltinRegistries.BIOME.getIds().size());
            lines.add("Number of Block IDs Registered: " + Registry.BLOCK.getIds().size());
            lines.add("Number of Item IDs Registered: " + Registry.ITEM.getIds().size());
            lines.add("Number of Potion IDs Registered: " + Registry.POTION.getIds().size());
            lines.add("Number of Enchantment IDs Registered: " + Registry.ENCHANTMENT.getIds().size());
            lines.add("Number of Fluid IDs Registered: " + Registry.FLUID.getIds().size());
            lines.add("Number of Tile Entities IDs Registered: " + Registry.BLOCK_ENTITY_TYPE.getIds().size());
            lines.add("Number of Entity IDs Registered: " + Registry.ENTITY_TYPE.getIds().size());

            matrixStack.translate(MinecraftClient.getInstance().getWindow().getScaledWidth(),MinecraftClient.getInstance().getWindow().getScaledHeight() - (lines.size() * tr.fontHeight),0);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);

                tr.draw(matrixStack, line, -tr.getWidth(line),i * tr.fontHeight, 14737632);
            }
        }
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