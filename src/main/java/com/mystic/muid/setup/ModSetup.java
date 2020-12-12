package com.mystic.muid.setup;

import com.mystic.muid.command.ModCommand;
import com.mystic.muid.helper.event.DebugInfoEvent;
import com.mystic.muid.util.reference;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = reference.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup
{
    @SubscribeEvent
    public static void serverLoad(FMLServerStartingEvent event) {
        ModCommand.register(event.getServer().getCommandManager().getDispatcher());
    }

    public static void init(final FMLCommonSetupEvent event) {
        DebugInfoEvent.createFile();
    }
}
