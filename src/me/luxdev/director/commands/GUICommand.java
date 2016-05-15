package me.luxdev.director.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.luxdev.director.basic.User;

public class GUICommand implements CommandExecutor{
	
	public static ItemStack clay = createItemWL(Material.CLAY, 1, (short) 0, "§aGlina", "§bKliknij aby kierowalo Cie na Gline.");
	public static ItemStack wedka = createItemWL(Material.FISHING_ROD, 1, (short) 0, "§aUltraWedka", "§bKliknij raz aby cie kierowalo.");
	
	@Override
	public boolean onCommand(CommandSender p, Command cmd, String s, String[] args) {
		if(cmd.getName().equalsIgnoreCase("DirectorGUI")){
			Player pl = (Player) p;
			User u = User.getUser(pl.getName());
			Inventory inv = Bukkit.createInventory(pl, 27, "§eWybierz Swoj Cel " + p.getName());
			inv.setItem(0, clay);
			pl.openInventory(inv);
			pl.getInventory().addItem(wedka);
		}
		return false;
	}
	private static ItemStack createItemWL(Material material, int amount, short data, String name, String... lore) {
	    ItemStack stack = new ItemStack(material, amount, data);
	    ItemMeta meta = stack.getItemMeta();
	    meta.setDisplayName(colorize(name));
	    ArrayList<String> loreList = new ArrayList<String>();
	    for (String s : lore) {
	        loreList.add(colorize(s));
	    }
	    meta.setLore(loreList);
	    stack.setItemMeta(meta);
	    return stack;
	}
	private static String colorize(String string) {
	    return ChatColor.translateAlternateColorCodes('&', string);
	}
}