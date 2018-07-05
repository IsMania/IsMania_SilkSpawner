package fr.ismania.silkspawner;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import fr.ismania.silkspawner.listeners.Listeners;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		getLogger().info("Plugin démarré !");

		//Enregistrement de l'event
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		ItemStack it = new ItemStack(Material.GOLD_PICKAXE);
		ItemMeta itm = it.getItemMeta();
		itm.setDisplayName("§c§lPioche à Spawners");
		it.setItemMeta(itm);
		
		Bukkit.getPlayer("Lucas_Aymon").getInventory().addItem(it);
		
	}

	public void onDisable() {

		getLogger().info("Plugin arrêté !");

	}

}
