package services;

import org.json.JSONObject;

import bd.InteractionBD;
import tools.AuthentificationTools;
import tools.ErrorJSON;

public class Authentification {
	public static JSONObject login(String id, String mdp) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);
		}
		if(mdp == null) {
			return ErrorJSON.serviceRefused("MDP Absent", -1);
		}
		if(InteractionBD.isIdConnected(AuthentificationTools.isIdConnnected(id))) {
			return ErrorJSON.serviceRefused("ID deja connecté", -1);
		}
		// insert BD
		return ErrorJSON.serviceAccepted(InteractionBD.updateBD(AuthentificationTools.insertAuth(id)));
	}
	
	public static JSONObject logout(String id) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID pas co", 1000);
		}
		// remove BD 
		return ErrorJSON.serviceAccepted(InteractionBD.updateBD(AuthentificationTools.deleteAuth(id)));
	}
}
