package me.luxdev.director.listeners;

import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.luxdev.director.basic.User;
import me.luxdev.director.commands.GUICommand;

public class PlayerInteractListener implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack im = p.getItemInHand();
		User u = User.getUser(p.getName());
		if (im.equals(GUICommand.wedka)) {
			if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || (e.getAction().equals(Action.RIGHT_CLICK_AIR))) {
				e.setCancelled(true);
				if (u.isWatchingclay()) {
					Location loc = circle(p.getLocation(), Material.CLAY, 20);
					if(loc == null){
						p.sendMessage("§7INFO: §6W lokalizacji 20 kratek wokol ciebie nie ma gliny ;(");
						return;
					}
					int i = (int) p.getLocation().distance(loc);
					p.sendMessage("§7INFO:§6 " + i + " Kratek Od Ciebie znajduje sie glina, powodzenia :)");
				}
			}
		}
	}

	public Location circle(Location loc, Material mat, int radius) {
		int cx = loc.getBlockX();
		int cy = loc.getBlockY();
		int cz = loc.getBlockZ();
		for (int x = cx - radius; x <= cx + radius; x++) {
			for (int z = cz - radius; z <= cz + radius; z++) {
				for (int y = (cy - radius); y < (cy + radius); y++) {
					double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));
					if (dist < radius * radius) {
						Location l = new Location(loc.getWorld(), x, y + 2, z);
						if (l.getBlock().getType() == mat) {
							return l;
						}
					}
				}
			}
		}
		return null;
	}

}
