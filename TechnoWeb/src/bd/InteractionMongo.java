package bd;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InteractionMongo {
	public JSONObject insert(String id, String texte) {
		Document doc = new Document();
		doc.append("id", id);
		doc.append("texte",texte);
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collec = db.getCollection(DBStatic.mongo_collection);
		collec.insertOne(doc);
		JSONObject res;
		try {
			res = new JSONObject().put("etat","reussi");
			return res;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public JSONObject execute() {
		
	}
}
