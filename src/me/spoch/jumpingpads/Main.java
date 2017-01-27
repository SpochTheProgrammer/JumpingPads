package me.spoch.jumpingpads;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

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

}
