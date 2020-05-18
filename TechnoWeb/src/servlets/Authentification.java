package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentification extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String mdp = req.getParameter("mdp");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Authentification.login(id,mdp));
	}
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Authentification.logout(id));
	}
}
