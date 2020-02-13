package services;

import org.json.JSONObject;

import tools.ErrorJSON;

public class Authentification {
	public static JSONObject login(String id, String mdp) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);
		}
		if(mdp == null) {
			return ErrorJSON.serviceRefused("MDP Absent", -1);
		}
		// insert BD
		return ErrorJSON.serviceAccepted();
	}
	
	public static JSONObject logout(String id) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID pas co", 1000);
		}
		// remove BD 
		return ErrorJSON.serviceAccepted();
	}
}
