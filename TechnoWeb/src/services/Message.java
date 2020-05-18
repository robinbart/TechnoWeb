package services;

import org.json.JSONObject;

import bd.InteractionMongo;
import tools.ErrorJSON;

public class Message {//ca depend de quel message il s'agit, mp ou tweet ???
	public static JSONObject removeMessage(String id1, String texte) {
		if(id1==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		//remove BD
		return InteractionMongo.delete(tools.MessageTools.deleteMessage(id1,texte));
	}
	
	public static JSONObject removeAllMessage(String id1) {
		if(id1==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		//remove BD
		return InteractionMongo.delete(tools.MessageTools.deleteAllMessage(id1));
	}
	
	public static JSONObject createMessage(String id1, String texte) {
		if(id1==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		//remove BD
		return InteractionMongo.insert(tools.MessageTools.insertMessage(id1,texte));
	}
	
	public static JSONObject getMessage(String id) {
		if(id==null) {
			return ErrorJSON.serviceRefused("L'utilisateur 1 n'existe pas", -1);
		}
		//remove BD
		return InteractionMongo.execute(tools.MessageTools.getMessage(id));
	}
}
