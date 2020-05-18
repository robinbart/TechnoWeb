package bd;

import java.util.Iterator;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import tools.ErrorJSON;

public class InteractionMongo {
	public static JSONObject insert(Document doc) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collec = db.getCollection(DBStatic.mongo_collection);
		collec.insertOne(doc);
		return ErrorJSON.serviceAccepted();
	}
	public static JSONObject execute(Document requete) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collec = db.getCollection(DBStatic.mongo_collection);
		FindIterable<Document> res = collec.find(requete);
		Iterator<Document> ite = res.iterator();
		JSONObject resultat = new JSONObject();
		int i = 0;
		while(ite.hasNext()) {
			try {
				resultat.put("Message "+i,ite.next());
			} catch (JSONException e) {
				return ErrorJSON.serviceRefused("pbJSON",100);
			}
			i++;
		}
		return resultat;
	}
	public static JSONObject delete(Document doc) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collec = db.getCollection(DBStatic.mongo_collection);
		collec.deleteOne(doc);
		return ErrorJSON.serviceAccepted();
	}
	public static JSONObject deleteAll(Document doc) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collec = db.getCollection(DBStatic.mongo_collection);
		collec.deleteMany(doc);
		return ErrorJSON.serviceAccepted();
	}
}
