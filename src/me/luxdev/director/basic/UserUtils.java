package me.luxdev.director.basic;

import java.util.ArrayList;
import java.util.List;


public class UserUtils {
	
	public static List<User> users = new ArrayList<User>(); 
	
		public static User getUser(String name) throws Exception{
		for (User u : users) {
		   if (u.getName().equals(name)) {
				return u;
		   }
		}
		return throw new Exception("User is null");
	}

}
