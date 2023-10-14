package com.mystic.muid;

import com.mystic.muid.command.DebugInfoCommand;
import com.mystic.muid.command.VillagerTradesCommand;
import com.mystic.muid.util.handler.RegistryHandler;
import com.mystic.muid.util.reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = reference.MODID, name = reference.NAME, version = reference.VERSION)
public class MUID {
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new DebugInfoCommand());
        event.registerServerCommand(new VillagerTradesCommand());
    }

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistries(event);
    }
}