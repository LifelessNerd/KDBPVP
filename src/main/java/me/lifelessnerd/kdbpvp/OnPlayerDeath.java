package me.lifelessnerd.kdbpvp;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnPlayerDeath implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent event){
	  	Player player = event.getEntity();

		// Potion
		ItemStack itemToAdd = new ItemStack(Material.SPLASH_POTION, 1);
		PotionMeta potionMeta = (PotionMeta) itemToAdd.getItemMeta();
		PotionEffect potEffect = new PotionEffect(PotionEffectType.HEAL, 2, 1, true, true);
        assert potionMeta != null; //idk wat dit is maar IntelliJ wilde het
        potionMeta.addCustomEffect(potEffect, true);
		itemToAdd.setItemMeta(potionMeta);

	  if (player.getWorld().getName().equalsIgnoreCase("pvp")) {
	  	if (player.getKiller() instanceof Player) {
			Player killer = player.getKiller();
			Inventory killerInventory = killer.getInventory();
			killerInventory.addItem(itemToAdd);

		}
	  }
	}
}
