package tools;

public class AuthentificationTools {
	public static String insertAuth(String id) {
		StringBuilder res = new StringBuilder();
		res.append("insert into Auth values ('");
		res.append(id);
		res.append("','");
		res.append(keyGenerator());
		res.append("');");
		
		return res.toString();
	}
	
	public static String deleteAuth(String id) {
		StringBuilder res = new StringBuilder();
		res.append("delete from Auth where Auth.id='");
		res.append(id);
		res.append("';");
		
		return res.toString();
	}
	
	public static String isIdConnnected(String id) {
		StringBuilder res = new StringBuilder();
		res.append("select Auth.id from Auth where Auth.id='");
		res.append(id);
		res.append("';");
		
		return res.toString();
		
	}
	
	public static String  keyGenerator() {
		return "coucou";
	}
}
