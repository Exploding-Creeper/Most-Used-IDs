package com.mystic.muid.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mystic.muid.util.reference;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ModCommand
{

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdDebug = dispatcher.register(
                Commands.literal(reference.MODID)
                        .then(DebugInfoCommand.register(dispatcher))
        );
    }

}
