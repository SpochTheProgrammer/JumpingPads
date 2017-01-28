package me.spoch.jumpingpads;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {

	@EventHandler // Player move event
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();

		if (ZetraAPI.getBlockFromLegs(player, 0).getType() == Material.GOLD_PLATE) {
			ZetraAPI.setVelocity(e.getPlayer(), 4.0);
		}

		if (player.getLocation().getY() < 25) { // if Y is 25 or less, teleport
												// to spawn
			ZetraAPI.tpToSpawn(player);
		}
	}

	@EventHandler // Another player move event
	public void onPlayerMove1(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (ZetraAPI.getBlockFromLegs(player, -1).getType() == Material.WOOL) {
			// Check if block -1 from players legs is wool ^^^^
			player.sendMessage("You are walking on a wool block!");
		}
	}

	@EventHandler // Entity damage event
	public void onDamage(EntityDamageEvent e) {
		if (e.getCause().equals(DamageCause.FALL)) {
			e.setCancelled(true); // Test if damage is caused by fall and cancel
									// it
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if ((event.getInventory().getName()).equalsIgnoreCase(ChatColor.AQUA + "Server Selector")) {
			event.setCancelled(true);
			if (event.getSlot() == 13) {
				ZetraAPI.tpToSpawn((Player) event.getWhoClicked());
			}
		}
	}
}
