package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

public class InteractionBD {
	public static JSONObject executeQuery(String tools){
		try {
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			
			ResultSet res = s.executeQuery(tools);
			JSONObject js = new JSONObject();
			int k =0;
			while(res.next()) {
				JSONObject transition = new JSONObject();
				for (int i = 1; i < res.getMetaData().getColumnCount() + 1; i++) {
					transition.put(res.getMetaData().getColumnName(i), res.getString(i));
				}
				js.put(k+"",transition);
				k++;
			}
			
			con.close();
			s.close();
			res.close();
			con.close();
			return js;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static JSONObject updateBD(String tools){
		try {
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			
			int res = s.executeUpdate(tools);
			JSONObject js = new JSONObject().put("oui",res);
			con.close();
			s.close();
			return js;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch (JSONException e) {
			return null;
		}
	}
	public static boolean isIdConnected(String tools){
		try {
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			
			ResultSet res = s.executeQuery(tools);
			con.close();
			s.close();
			if(res.next()) {
				res.close();
				return true;
			}

			res.close();
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
