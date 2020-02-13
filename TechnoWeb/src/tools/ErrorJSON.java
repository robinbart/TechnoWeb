package tools;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorJSON {
	public static JSONObject serviceRefused(String message, int codeErreur){
		//—  Code -1 erreur d’arguments pass ́e au Web service (argument manquant, mauvais format, ...)
		//—  Code 100 erreur de JSON
		//—  Code 1000 erreur de SQL
		//—  Code 10000 erreur de JAVA
		try {
			JSONObject res = new JSONObject().put("message",message);
			return res.put("codeErreur",codeErreur);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static JSONObject serviceAccepted() {
		try {
			return new JSONObject().put("etat", "reussi");
		}catch(JSONException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
