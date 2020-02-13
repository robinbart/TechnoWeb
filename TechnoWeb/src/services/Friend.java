package services;

import org.json.JSONObject;

import tools.ErrorJSON;

public class Friend {

	public static JSONObject removeFriend(String id1, String id2) {
		if(idInexistant(id1)) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		if(idInexistant(id2)) {
			return ErrorJSON.serviceRefused("L'utilisateur 2 n'existe pas", -1);
		}
		//remove BD
		return ErrorJSON.serviceAccepted();
	}
	
	public static JSONObject addUser(String id1, String id2) {
		if(idInexistant(id1)) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		if(idInexistant(id2)) {
			return ErrorJSON.serviceRefused("L'utilisateur 2 n'existe pas", -1);
		}
		//insert BD
		return ErrorJSON.serviceAccepted();
	}
	
	public static JSONObject getfrienList(String id) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);
		}
		//select BD
		return ErrorJSON.serviceAccepted();
	}
}
