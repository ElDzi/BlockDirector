package me.luxdev.director;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.luxdev.director.commands.GUICommand;
import me.luxdev.director.listeners.InventoryClickListener;
import me.luxdev.director.listeners.PlayerInteractListener;
import me.luxdev.director.listeners.PlayerJoinListener;

public class Main extends JavaPlugin{
	
	private static Main instance;
	
	public void onEnable(){
		instance = this;
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		getCommand("directorgui").setExecutor(new GUICommand());
		
	}
	public void onDisable(){
		
	}
	public static Main getInst(){
		return instance;
	}
}
