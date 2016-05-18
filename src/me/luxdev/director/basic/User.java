package me.luxdev.director.basic;

public class User {
	
	private String name;
	private boolean watchingclay;
	private boolean watchingIronOre;
	
	public User(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public boolean isWatchingclay() {
		return watchingclay;
	}
	public void setWatchingclay(boolean watchingclay) {
		this.watchingclay = watchingclay;
	}
	public boolean isWatchingIronOre() {
		return watchingIronOre;
	}
	public void setWatchingIronOre(boolean watchingIronOre) {
		this.watchingIronOre = watchingIronOre;
	}
	public static User getUser(String name) throws Exception{
		for (User u : UserUtils.users) {
			if (u.getName().equals(name)) {
				return u;
			}
		}
		throw new Exception("User is null.");
	}
}
