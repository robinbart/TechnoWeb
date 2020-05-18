package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String mdp = req.getParameter("mdp");
		String mail = req.getParameter("mail");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Users.createUser(id,mdp,mail,nom,prenom));
	}
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Users.deleteUser(id));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] tab = param.split("/");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Users.getUser(tab[0]));
	}
}
