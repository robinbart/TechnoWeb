package tools;

public class UserTools {
	public static String insertUser(String id, String mdp, String mail, String nom, String prenom) {
		StringBuilder res = new StringBuilder();
		res.append("insert into User values ('");
		res.append(id);
		res.append("','");
		res.append(mdp);
		res.append("','");
		res.append(mail);
		res.append("','");
		res.append(nom);
		res.append("','");
		res.append(prenom);
		res.append("');");
		
		return res.toString();
	}
	
	public static String deleteUser(String id) {
		StringBuilder res = new StringBuilder();
		res.append("delete from User where User.id='");
		res.append(id);
		res.append("';");
		
		return res.toString();
	}
	
	public static String getUser(String id) {
		StringBuilder res = new StringBuilder();
		if(id != "all") {
			res.append("select * from User where User.id='");
			res.append(id);
			res.append("';");
		}else {
			res.append("select * from User;");
		}
		
		return res.toString();
	}
	


	public static boolean passwordNonConforme(String mdp) {
		if(mdp.length()<20 && mdp.length()>5) {
			return true;
		}
		return false;
	}
}
