package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

import bd.Database;
import bd.InteractionBD;
import tools.ErrorJSON;
import tools.FriendTools;
import tools.UserTools;

public class Users{
	
	public static JSONObject createUser(String id, String mdp, String mail, String nom, String prenom) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);	
		}
		if(mdp == null) {
			return ErrorJSON.serviceRefused("MDP Absent", -1);
		}
		if(mail == null) {
			return ErrorJSON.serviceRefused("Mail Absent", -1);
		}
		if(nom == null) {
			return ErrorJSON.serviceRefused("Nom Absent", -1);
		}
		if(prenom == null) {
			return ErrorJSON.serviceRefused("Prenom Absent", -1);
		}
		if(UserTools.passwordNonConforme(mdp)) {
			return ErrorJSON.serviceRefused("MDP non conforme", -1);
		}
		// insert BD
		return ErrorJSON.serviceAccepted(InteractionBD.updateBD(UserTools.insertUser(id, mdp, mail, nom, prenom)));
		
	}
	
	public static JSONObject getUser(String id) {
		if(id==null) {
			return ErrorJSON.serviceRefused("L'utilisateur n'existe pas", -1);
		}
		//select BD
		return ErrorJSON.serviceAccepted(InteractionBD.executeQuery(UserTools.getUser(id)));
	}
	public static JSONObject deleteUser(String id) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);
		}
		//delete BD
		
		return ErrorJSON.serviceAccepted(InteractionBD.updateBD(UserTools.deleteUser(id)));

	}
	public static JSONObject getUserList() {
		// select BD
		return ErrorJSON.serviceAccepted(InteractionBD.executeQuery(UserTools.getUser("all")));

	}
}
