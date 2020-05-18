package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Message extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String texte = req.getParameter("texte");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Message.createMessage(id,texte));
	}
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String texte = req.getParameter("texte");
		resp.setContentType("applicatyion/json");
		if(texte==null) {
			resp.getWriter().print(services.Message.removeAllMessage(id));
		}
		else {
			resp.getWriter().print(services.Message.removeMessage(id,texte));
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getPathInfo();
		String[] tab = param.split("/");
		resp.setContentType("applicatyion/json");
		resp.getWriter().print(services.Message.getMessage(tab[0]));
	}
}
