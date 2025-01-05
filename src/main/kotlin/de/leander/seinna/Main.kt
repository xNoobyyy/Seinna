package de.leander.seinna

import de.leander.seinna.commands.TestCommand
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.annotations.ApiStatus

class Main : JavaPlugin() {

    companion object {
        lateinit var instance: Main private set
    }

    override fun onLoad() {
        instance = this
    }

    override fun onEnable() {
        logger.info("Seinna has been enabled!")

        lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS, { event ->
            val commands = event.registrar()

            commands.register("test", TestCommand)
        })
    }

    override fun onDisable() {
        logger.info("Seinna has been disabled!")
    }

}

val Seinna = lazy { Main.instance }