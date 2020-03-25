package test;

import org.json.JSONException;

import services.Users;

public class testCreateUser {
	public static void main(String[] args) {
		System.out.println(Users.createUser("12","mdp", "mail","nom","prenom").toString());
		System.out.println(Users.createUser(null,"mdp", "mail","nom","prenom").toString());
		System.out.println(Users.createUser("12",null, "mail","nom","prenom").toString());
		System.out.println(Users.createUser("12","mdp", null,"nom","prenom").toString());
	}

}
 