package fr.ismania.silkspawner.listeners;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		ItemStack poule = new ItemStack((Material.MOB_SPAWNER));
		Material detruit = e.getBlock().getType();

		ItemStack t = new ItemStack(Material.GOLD_PICKAXE, 1);
		ItemMeta tM = t.getItemMeta();
		tM.setDisplayName("§6Récupérateur de spawners");
		tM.addEnchant(Enchantment.SILK_TOUCH, 200, true);
		tM.setLore(Arrays.asList("§7Récupérez vos spawners avec cette pioche"));
		tM.hasItemFlag(ItemFlag.HIDE_DESTROYS);
		t.setItemMeta(tM);
		t.setDurability((short)1);		

		if(detruit == Material.MOB_SPAWNER) {
			
			CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
			ItemStack itemInHand = p.getItemInHand();
			
			if(p.getWorld() == Bukkit.getWorld("ASkyBlock")) {
				
				if(itemInHand.getType() == Material.GOLD_PICKAXE && itemInHand.getItemMeta().getDisplayName().equals("§c§lPioche à Spawners")) {
					
					if(spawner.getSpawnedType() == EntityType.CHICKEN) {
						p.getInventory().addItem(poule);
					}

				} else {
					p.sendMessage("Tu ne peux pas récupérer de spawners dans ce monde !");
					e.setCancelled(true);
				}

			}

		}
		
	}
	
}

