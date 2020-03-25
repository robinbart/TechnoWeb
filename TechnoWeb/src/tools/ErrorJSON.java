package tools;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorJSON {
	public static JSONObject serviceRefused(String message, int codeErreur){
		//â€”  Code -1 erreur dâ€™arguments pass Ì�e au Web service (argument manquant, mauvais format, ...)
		//â€”  Code 100 erreur de JSON
		//â€”  Code 1000 erreur de SQL
		//â€”  Code 10000 erreur de JAVA
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
	public static JSONObject serviceAccepted(JSONObject js) {
		return js;
	}
}
