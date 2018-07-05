package fr.ismania.silkspawner.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {

		Player p = e.getPlayer();
		//Variable pour le récupérer le material détruit
		Material detruit = e.getBlock().getType();

		//Vérification si le material détruit est un spawner
		if(detruit == Material.MOB_SPAWNER) {

			//Recupération du state du block
			CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
			ItemStack itemInHand = p.getItemInHand();

			if(itemInHand == null) return;

			if(!p.hasPermission("sp.bypass")) {

				//Vérification du monde
				if(p.getWorld() == Bukkit.getWorld("ASkyBlock")) {

					//Vérification du nom de la pioche
					if(itemInHand.getItemMeta().getDisplayName().equals("§c§lPioche à Spawners") && itemInHand.getItemMeta().getDisplayName() != null) {
						//Vérification des mobs spawner par le spawner
						if(spawner.getSpawnedType() == EntityType.CHICKEN || spawner.getSpawnedType() == EntityType.VILLAGER || spawner.getSpawnedType() == EntityType.BLAZE || spawner.getSpawnedType() == EntityType.SKELETON || spawner.getSpawnedType() == EntityType.ZOMBIE || spawner.getSpawnedType() == EntityType.CREEPER || spawner.getSpawnedType() == EntityType.PIG || spawner.getSpawnedType() == EntityType.COW || spawner.getSpawnedType() == EntityType.SPIDER || spawner.getSpawnedType() == EntityType.SQUID || spawner.getSpawnedType() == EntityType.RABBIT || spawner.getSpawnedType() == EntityType.SHEEP || spawner.getSpawnedType() == EntityType.SLIME || spawner.getSpawnedType() == EntityType.WITCH || spawner.getSpawnedType() == EntityType.GUARDIAN) {

							p.getInventory().remove(itemInHand);

						}

					}

				} else {
					p.sendMessage("§cTu ne peux pas récupérer de spawners dans ce monde !");
					e.setCancelled(true);
				}

			}

		}

	}

}

