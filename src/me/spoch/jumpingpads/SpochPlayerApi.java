package me.spoch.jumpingpads;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SpochPlayerApi {

	public static Block getBlockFromLegs(Player p, int y) {
		Location loc = p.getLocation().clone().add(0, y, 0);
		Block block = loc.getBlock();
		return block;
	}
}
