package com.mystic.muid;

import com.mystic.muid.command.ModCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() {
		System.out.println("Derp Derp");
		CommandRegistrationCallback.EVENT.register((commandDispatcher, b) -> ModCommand.register(commandDispatcher));
	}
}
