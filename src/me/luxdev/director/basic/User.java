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

}
