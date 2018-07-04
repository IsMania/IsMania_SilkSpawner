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
		//Variable pour le récupérer le material détruit
		Material detruit = e.getBlock().getType();

		//Vérification si le material détruit est un spawner
		if(detruit == Material.MOB_SPAWNER) {
			
			//Recupération du state du block
			CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
			ItemStack itemInHand = p.getItemInHand();
			
			if(itemInHand == null) return;
			
			if(p.hasPermission("sp.bypass")) {
				
				//Vérification du nom de la pioche
				if(itemInHand.getItemMeta().getDisplayName().equals("§c§lPioche à Spawners") && itemInHand.getItemMeta().getDisplayName() != null) {
					
					//Vérification des mobs spawner par le spawner
					if(spawner.getSpawnedType() == EntityType.CHICKEN || spawner.getSpawnedType() == EntityType.VILLAGER || spawner.getSpawnedType() == EntityType.BLAZE || spawner.getSpawnedType() == EntityType.SKELETON || spawner.getSpawnedType() == EntityType.ZOMBIE || spawner.getSpawnedType() == EntityType.CREEPER || spawner.getSpawnedType() == EntityType.PIG || spawner.getSpawnedType() == EntityType.COW || spawner.getSpawnedType() == EntityType.SPIDER || spawner.getSpawnedType() == EntityType.SQUID || spawner.getSpawnedType() == EntityType.RABBIT || spawner.getSpawnedType() == EntityType.SHEEP || spawner.getSpawnedType() == EntityType.SLIME || spawner.getSpawnedType() == EntityType.WITCH || spawner.getSpawnedType() == EntityType.GUARDIAN) {
						
						//Nouvelle item spawner
						ItemStack mob_spawner = new ItemStack(Material.MOB_SPAWNER);
						//BlockState de l'item spawner
						BlockStateMeta mob_spawner_meta = (BlockStateMeta) mob_spawner.getItemMeta();
						
						//Creation de la "créature" du spawner
						CreatureSpawner cSpawner = spawner;
						cSpawner.setSpawnedType(spawner.getSpawnedType());
						cSpawner.setCreatureTypeByName(spawner.getCreatureTypeName());
						
						//On set le blockstate du spawner
						mob_spawner_meta.setBlockState(cSpawner);
						mob_spawner_meta.setDisplayName(cSpawner.getCreatureTypeName() + " Spawner");
						mob_spawner.setItemMeta(mob_spawner_meta);
						
						//On drop l'item du spawner
						p.getWorld().dropItem(p.getLocation(), mob_spawner);
						
					}
				}
				
			} else {
				
				//Vérification du monde
				if(p.getWorld() == Bukkit.getWorld("ASkyBlock")) {
				
				//Vérification du nom de la pioche
				if(itemInHand.getItemMeta().getDisplayName().equals("§c§lPioche à Spawners") && itemInHand.getItemMeta().getDisplayName() != null) {
					p.getInventory().getItemInMainHand().setType(Material.AIR);
					//Vérification des mobs spawner par le spawner
					if(spawner.getSpawnedType() == EntityType.CHICKEN || spawner.getSpawnedType() == EntityType.VILLAGER || spawner.getSpawnedType() == EntityType.BLAZE || spawner.getSpawnedType() == EntityType.SKELETON || spawner.getSpawnedType() == EntityType.ZOMBIE || spawner.getSpawnedType() == EntityType.CREEPER || spawner.getSpawnedType() == EntityType.PIG || spawner.getSpawnedType() == EntityType.COW || spawner.getSpawnedType() == EntityType.SPIDER || spawner.getSpawnedType() == EntityType.SQUID || spawner.getSpawnedType() == EntityType.RABBIT || spawner.getSpawnedType() == EntityType.SHEEP || spawner.getSpawnedType() == EntityType.SLIME || spawner.getSpawnedType() == EntityType.WITCH || spawner.getSpawnedType() == EntityType.GUARDIAN) {
						
						//Nouvelle item spawner
						ItemStack mob_spawner = new ItemStack(Material.MOB_SPAWNER);
						//BlockState de l'item spawner
						BlockStateMeta mob_spawner_meta = (BlockStateMeta) mob_spawner.getItemMeta();
						
						//Creation de la "créature" du spawner
						CreatureSpawner cSpawner = spawner;
						cSpawner.setSpawnedType(spawner.getSpawnedType());
						cSpawner.setCreatureTypeByName(spawner.getCreatureTypeName());
						
						//On set le blockstate du spawner
						mob_spawner_meta.setBlockState(cSpawner);
						mob_spawner_meta.setDisplayName(cSpawner.getCreatureTypeName() + " Spawner");
						mob_spawner.setItemMeta(mob_spawner_meta);
						
						//On drop l'item du spawner
						p.getWorld().dropItem(p.getLocation(), mob_spawner);
						
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

