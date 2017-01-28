package me.spoch.jumpingpads;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {

	@SuppressWarnings("deprecation")
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(new Events(), this);
		this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {

			public void run() {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.setFoodLevel(20);
				}
			}
		}, (3) * 20L, 1L);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ItemStack spawnItem = new ItemStack(Material.GRASS);
		ItemMeta spawnItemMeta = spawnItem.getItemMeta();
		spawnItemMeta.setDisplayName(ChatColor.GREEN + "SPAWN");
		spawnItem.setItemMeta(spawnItemMeta);
		Inventory invName = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Server Selector");
		invName.setItem(13, spawnItem);
		((HumanEntity) sender).openInventory(invName);
		return false;
	}
}
