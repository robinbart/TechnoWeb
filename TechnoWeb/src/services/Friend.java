package services;

import org.json.JSONObject;

import bd.InteractionBD;
import tools.AuthentificationTools;
import tools.ErrorJSON;
import tools.FriendTools;

public class Friend {

	public static JSONObject removeFriend(String id1, String id2) {
		if(id1==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		if(id2==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 2 n'existe pas", -1);
		}
		//remove BD
		return ErrorJSON.serviceAccepted(InteractionBD.updateBD(FriendTools.deleteFriend(id1,id2)));
	}
	
	public static JSONObject addFriend(String id1, String id2) {
		if(id1==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		if(id2==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 2 n'existe pas", -1);
		}
		//insert BD
		return ErrorJSON.serviceAccepted(InteractionBD.updateBD(FriendTools.insertFriend(id1,id2)));
	}
	
	public static JSONObject getFrienList(String id) {
		if(id == null) {
			return ErrorJSON.serviceRefused("ID Absent", -1);
		}
		//select BD
		return ErrorJSON.serviceAccepted(InteractionBD.executeQuery(FriendTools.getFriendList(id)));
	}
}
