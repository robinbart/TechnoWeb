package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

import bd.Database;

public class TestDB {
	public static JSONObject testDB() {
		try {
			String sql = "Select * from User";
			Connection con = Database.getMySQLConnection();
			Statement s = con.createStatement();
			
			ResultSet res = s.executeQuery(sql);
			res.next();
			System.out.println(res.getInt("id"));
			con.close();
			return new JSONObject().put("val", res.getInt("id"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
/*try {
	String sql = "Select * from User";
	Connection con = Database.getMySQLConnection();
	Statement s = con.createStatement();
	
	ResultSet res = s.executeQuery(sql);
	res.next();
	resp.getWriter().println(res.getInt("id"));
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}*/