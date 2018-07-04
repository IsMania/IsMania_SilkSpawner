package fr.ismania.silkspawner;

import org.bukkit.plugin.java.JavaPlugin;

import fr.ismania.silkspawner.listeners.Listeners;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		getLogger().info("Plugin démarré !");
		getServer().getPluginManager().registerEvents(new Listeners(), this);

	}

	public void onDisable() {

		getLogger().info("Plugin arrêté !");

	}

}
