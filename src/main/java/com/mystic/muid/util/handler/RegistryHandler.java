package com.mystic.muid.util.handler;

import com.google.common.collect.Maps;
import com.mystic.muid.command.DebugInfoCommand;
import com.mystic.muid.helper.events.DebugInfoEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.handshake.FMLHandshakeMessage;

import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber
public class RegistryHandler {
    public static void preInitRegistries(FMLPreInitializationEvent event)
    {
        DebugInfoEvent.createFile();
        DebugInfoEvent.createVillagerRecipeList();
    }
}
