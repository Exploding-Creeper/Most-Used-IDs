package com.mystic.muid;

import com.mystic.muid.helper.event.DebugInfoEvent;
import com.mystic.muid.setup.ClientSetup;
import com.mystic.muid.setup.ModSetup;
import com.mystic.muid.util.reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(reference.MODID)
public class main
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}
