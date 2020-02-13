package services;

import org.json.JSONException;
import org.json.JSONObject;

import tools.ErrorJSON;

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
		if(idDejaPris(id)) {
			return ErrorJSON.serviceRefused("ID deja pris", -1);
		}
		if(passwordNonConforme(mdp)) {
			return ErrorJSON.serviceRefused("MDP non conforme", -1);
		}
		// insert BD
		return ErrorJSON.serviceAccepted();
	}
	
	public static JSONObject getUser(String nom, String prenom) {
		if(nom == null) {
			return ErrorJSON.serviceRefused("Nom Absent", -1);
		}
		if(prenom == null) {
			return ErrorJSON.serviceRefused("Prenom Absent", -1);
		}
		if(userInexistant(nom, prenom)) {
			return ErrorJSON.serviceRefused("L'utilisateur n'existe pas", -1);
		}
		//select BD
		return ErrorJSON.serviceAccepted();
	}
	public static JSONObject deleteUser(String id) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);
		}
		if(idInexistant(id)) {
			return ErrorJSON.serviceRefused("L'utilisateur n'existe pas", -1);
		}
		//delete BD
		return ErrorJSON.serviceAccepted();
	}
	public static JSONObject getUserList() {
		// select BD
		return ErrorJSON.serviceAccepted();
	}
}
