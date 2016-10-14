package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercise2Servlet
 */
@WebServlet("/headers")
public class Exercise2Servlet extends HttpServlet {

	private static final String NEW_LINE = "\n";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Exercise2Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();

		String protocol = request.getProtocol();
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String language = request.getLocale().getDisplayLanguage();
		String remoteAddress = request.getRemoteAddr();

		sb.append("PROTOCOL=");
		sb.append(protocol);
		sb.append(NEW_LINE);
		sb.append("URL=");
		sb.append(url);
		sb.append(NEW_LINE);
		sb.append("METHOD=");
		sb.append(method);
		sb.append(NEW_LINE);
		sb.append("LANGUAGE=");
		sb.append(language);
		sb.append(NEW_LINE);
		sb.append("REMOTE ADDRESS=");
		sb.append(remoteAddress);
		sb.append(NEW_LINE);

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			sb.append(headerName + "=" + headerValue);
			sb.append(NEW_LINE);

		}
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.close();

	}

}
