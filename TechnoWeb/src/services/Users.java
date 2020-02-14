package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

import bd.Database;
import tools.ErrorJSON;
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
		if(passwordNonConforme(mdp)) {
			return ErrorJSON.serviceRefused("MDP non conforme", -1);
		}
		// insert BD
		try {
			String sql = UserTools.insertUser(id, mdp, mail, nom, prenom);
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
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
		try {
			String id = "";
			String sql = UserTools.getUser(id);
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
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
		try {
			String sql = UserTools.deleteUser(id);
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return ErrorJSON.serviceAccepted();
	}
	public static JSONObject getUserList() {
		// select BD
		try {
			String sql = UserTools.deleteUser("all");
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery(sql);
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return ErrorJSON.serviceAccepted();
	}
}
