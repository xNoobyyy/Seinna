package de.leander.seinna.commands

import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.text.Component

object TestCommand : BasicCommand {

    override fun execute(ctx: CommandSourceStack, args: Array<out String>) {
        ctx.sender.sendMessage(Component.text("Hello, World!"))
    }

    override fun suggest(ctx: CommandSourceStack, args: Array<out String>): MutableCollection<String> {
        return mutableListOf()
    }

}