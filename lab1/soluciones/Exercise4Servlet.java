package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio4Servlet
 */
@WebServlet("/login")
public class Exercise4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Exercise4Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Form</h1>");
		out.println("<form action='login' method='post'>");
		out.println("<input type='text' name='name' placeholder='user'>");
		out.println("<br>");
		out.println("<input type='password' name='key' placeholder='password'> ");
		out.println("<br>");
		out.println("<input type='submit' value='Send'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("key");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (name.equals("user1") || password.equals("password1")) {

			out.println("<html>");
			out.println("<body>");
			out.println("<p> These are your data: " + name + " and key: " + password + "</p>");
			out.println("</body>");
			out.println("</html>");
			out.close();

		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<p> Invalid user</p>");
			out.println("<p> <a href='login'>Back</a></p>");
			out.println("</body>");
			out.println("</html>");
			out.close();

		}
	}

}
