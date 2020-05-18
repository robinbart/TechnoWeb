package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Friend extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//ajout:creation
		String id1 = req.getParameter("id1");
		String id2 = req.getParameter("id2");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Friend.addFriend(id1,id2));
	}
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//delete
		String id1 = req.getParameter("id1");
		String id2 = req.getParameter("id2");

		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Friend.removeFriend(id1,id2));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//recup
		String param = req.getPathInfo();
		String[] tab = param.split("/");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Friend.getFriendList(tab[0]));
	}
}
