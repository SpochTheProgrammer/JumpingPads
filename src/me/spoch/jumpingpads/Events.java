package me.spoch.jumpingpads;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener {
	
	@EventHandler // Player move event
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();

		if (SpochPlayerApi.getBlockFromLegs(player, 0).getType() == Material.GOLD_PLATE) {
			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().clone().multiply(5.0));
		}
		if (player.getLocation().getY() < 25) { // if Y is 25 or less, teleport
												// to spawn
			player.teleport(player.getWorld().getSpawnLocation());
		}
	}

	@EventHandler // Another player move event
	public void onPlayerMove1(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (SpochPlayerApi.getBlockFromLegs(player, -1).getType() == Material.WOOL) {
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
}
