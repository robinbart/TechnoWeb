package tools;

import org.bson.Document;

public class MessageTools {
	public static Document insertMessage(String texte, String owner_id) {
		Document res = new Document();
		res.append("owner_id",owner_id);
		res.append("texte",texte);
		return res;
	}
	
	public static Document deleteMessage(String texte, String owner_id) {
		Document res = new Document();
		res.append("owner_id",owner_id);
		res.append("texte",texte);
		return res;
	}
	
	public static Document deleteAllMessage(String owner_id) {
		Document res = new Document();
		res.append("owner_id",owner_id);
		return res;
	}
	
	public static Document getMessage(String owner_id) {
		Document res = new Document();
		res.append("owner_id",owner_id);
		return res;
	}
}


