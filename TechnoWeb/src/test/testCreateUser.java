package test;

import org.json.JSONException;

import services.Users;

public class testCreateUser {
	public static void main(String[] args) {
		try{
			System.out.println(Users.createUser("12","mdp", "mail").toString());
			System.out.println(Users.createUser(null,"mdp", "mail").toString());
			System.out.println(Users.createUser("12",null, "mail").toString());
			System.out.println(Users.createUser("12","mdp", null).toString());
		}catch(JSONException e) {
			System.out.println(e.getMessage());
		}
	}

}
 