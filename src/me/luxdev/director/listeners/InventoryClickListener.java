package me.luxdev.director.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.luxdev.director.basic.User;
import me.luxdev.director.commands.GUICommand;

public class InventoryClickListener implements Listener{
	
	@EventHandler
	public void invClickEvt(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		ItemStack im = e.getCurrentItem();
		try{
		User u = User.getUser(p.getName());
			if(im.equals(GUICommand.clay)){
			if(u.isWatchingclay()){
				e.setCancelled(true);
				u.setWatchingclay(false);
				p.sendMessage("§7INFO: §6Wedka juz nie bedzie cie kierowac na gline..");
				return;
			}else{
				e.setCancelled(true);
				u.setWatchingclay(true);
				p.closeInventory();
				p.sendMessage("§7INFO: §6Aktualnie wedka po kliknieciu bedzie cie kierowac na Gline..");
			}
		}
		}catch(Exception e){}
	
	}
}
