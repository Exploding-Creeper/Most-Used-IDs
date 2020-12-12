package com.mystic.muid;

import com.mystic.muid.command.DebugInfoCommand;
import com.mystic.muid.proxy.CommonProxy;
import com.mystic.muid.util.handler.RegistryHandler;
import com.mystic.muid.util.reference;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.util.logging.Logger;

@Mod(modid = reference.MODID, name = reference.NAME, version = reference.VERSION)
public class main {

    @Mod.Instance(reference.MODID)
    public static main INSTANCE;

    public static Logger logger;

    @SidedProxy(clientSide = reference.CLIENT_PROXY_CLASS, serverSide = reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new DebugInfoCommand());
    }

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegistryHandler.initRegistries(event);
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
        RegistryHandler.postInitRegistries(event);
    }
}