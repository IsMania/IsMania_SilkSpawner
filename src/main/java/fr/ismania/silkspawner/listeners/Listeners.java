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
import org.bukkit.inventory.meta.BlockStateMeta;

public class Listeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Material detruit = e.getBlock().getType();

		if(detruit == Material.MOB_SPAWNER) {
			
			CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
			ItemStack itemInHand = p.getItemInHand();
			
			if(p.getWorld() == Bukkit.getWorld("ASkyBlock")) {
				
				if(itemInHand.getType() == Material.GOLD_PICKAXE && itemInHand.getItemMeta().getDisplayName().equals("§c§lPioche à Spawners")) {
					
					if(spawner.getSpawnedType() == EntityType.CHICKEN) {
						
						ItemStack mob_spawner = new ItemStack(Material.MOB_SPAWNER);
						BlockStateMeta mob_spawner_meta = (BlockStateMeta) mob_spawner.getItemMeta();
						
						CreatureSpawner cSpawner = spawner;
						cSpawner.setSpawnedType(spawner.getSpawnedType());
						
						mob_spawner_meta.setBlockState(cSpawner);
						
						p.getWorld().dropItem(e.getBlock().getLocation(), mob_spawner);
						
					}

				} else {
					p.sendMessage("Tu ne peux pas récupérer de spawners dans ce monde !");
					e.setCancelled(true);
				}

			}

		}
		
	}
	
}

