package me.spoch.jumpingpads;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ZetraAPI {

	public static Block getBlockFromLegs(Player p, int y) {
		Location loc = p.getLocation().clone().add(0, y, 0);
		Block block = loc.getBlock();
		return block;
	}

	public static void setVelocity(Player p, Double strength) {
		p.getPlayer().setVelocity(p.getPlayer().getLocation().getDirection().clone().multiply(strength));
	}
	
	public static void tpToSpawn(Player p) {
		p.teleport(p.getWorld().getSpawnLocation());
	}
	
	public static void tpTo(Player p, Location loc) {
		p.teleport(loc);
	}
}
