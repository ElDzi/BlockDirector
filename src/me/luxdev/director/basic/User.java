package me.luxdev.director.basic;

public class User {
	
	private String name;
	private boolean Watchingclay;
	private boolean WatchingIronOre;
	
	public User(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public boolean isWatchingclay() {
		return Watchingclay;
	}
	public void setWatchingclay(boolean watchingclay) {
		Watchingclay = watchingclay;
	}
	public boolean isWatchingIronOre() {
		return WatchingIronOre;
	}
	public void setWatchingIronOre(boolean watchingIronOre) {
		WatchingIronOre = watchingIronOre;
	}
	public static User getUser(String name){
		for (User u : UserUtils.users) {
			if (u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}
}
