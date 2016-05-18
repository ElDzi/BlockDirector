package me.luxdev.director.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.luxdev.director.basic.User;
import me.luxdev.director.basic.UserUtils;

public class PlayerJoinListener implements Listener{ 
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		User u = new User(e.getPlayer().getName());
		if(UserUtils.users.contain(p))return;
		UserUtils.users.add(p);
	}
	  
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		User u = UserUtils.getUser(e.getPlayer().getName());
		if (u != null)UserUtils.users.remove(u);
		  
	}
}
