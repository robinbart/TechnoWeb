package tools;

public class FriendTools {
	public static String insertFriend(String id1, String id2) {
		StringBuilder res = new StringBuilder();
		res.append("insert into Friend values ('");
		res.append(id1);
		res.append("','");
		res.append(id2);
		res.append("');");
		
		return res.toString();
	}
	
	public static String deleteFriend(String id1, String id2) {
		StringBuilder res = new StringBuilder();
		res.append("delete from Friend where Friend.id1='");
		res.append(id1);
		res.append("' and Friend.id2='");
		res.append(id2);
		res.append("';");
		
		return res.toString();
	}
	
	public static String getFriendList(String id) {
		StringBuilder res = new StringBuilder();
			res.append("select * from Friend where Friend.id='");
			res.append(id);
			res.append("';");
		
		return res.toString();
	}
}
