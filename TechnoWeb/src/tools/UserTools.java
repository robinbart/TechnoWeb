package tools;

public class UserTools {
	public static String insertUser(String id, String mdp, String mail, String nom, String prenom) {
		StringBuilder res = new StringBuilder();
		res.append("insert into User value (");
		res.append(id);
		res.append(",");
		res.append(mdp);
		res.append(",");
		res.append(mail);
		res.append(",");
		res.append(nom);
		res.append(",");
		res.append(prenom);
		res.append(");");
		
		return res.toString();
	}
	
	public static String deleteUser(String id) {
		StringBuilder res = new StringBuilder();
		res.append("delete from User where User.id=");
		res.append(id);
		res.append(";");
		
		return res.toString();
	}
	
	public static String getUser(String id) {
		StringBuilder res = new StringBuilder();
		res.append("select User.id from User where User.id=");
		res.append(id);
		res.append(";");
		
		return res.toString();
	}
}
