package es.uc3m.tiw.lab2.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.tiw.lab1.dominios.Usuario;
import es.uc3m.tiw.lab2.Conector;
import es.uc3m.tiw.lab2.daos.UsuarioDAO;
import es.uc3m.tiw.lab2.daos.UsuarioDAOImpl;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private UserDAO dao;
	private Connection con;
	private static final String ADD="ADD",EDIT="EDIT",DELETE="DELETE";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		String configuracion = (String)config.getServletContext().getInitParameter("configuration");
		ResourceBundle rb = ResourceBundle.getBundle(configuracion);
		Connector connector = Connector.getInstance();
		//con = conector.crearConexionMySQL(rb);
		Connection con = connector.createConnectionMySQLWithJNDI(rb) ;
		dao = new UserDAOImpl();
		dao.setConnection(con);
		dao.setQuerys(rb);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

			String page = null;
		
			if (accion.equals(ADD)) {
				page = "/adduser.jsp";
				
			}else if (accion.equals(EDIT)) {
				User user = getUserData(request);
				request.setAttribute("user", user);
				page = "/edituser.jsp";
				
			}else if (accion.equals(DELETE)) {
				User user = getUserData(request);
				page = "/login.jsp";
				deleteUser(user);
			}
			config.getServletContext().getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * Obtiene los datos del usuario a editar o borrar
	 * @param request
	 * @return
	 */
	private User getUserData(HttpServletRequest request) {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		String pagina = "/login.jsp";
		if ((sesion.getAttribute("authenticate").toString()).equalsIgnoreCase("true")) {
			
			pagina = "/form?name=root&key=admin";
		
		if (accion.equalsIgnoreCase(ADD)) {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			addUser(user);
		}else if (accion.equalsIgnoreCase(EDIT)) {
			User user = getUserData(request);
			updateUser(user);
		 }
		}
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}
	/**
	 * Modifica los datos del usuario con el UsuarioDao
	 * @param usuario
	 */
	private void updateUser(User user){
		try {
			dao.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Borra los datos de un usuario con el UsuarioDao
	 * @param usuario
	 */
	private void deleteUser(User user){
		try {
			dao.deleteUser(user); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Crea un usuario en la base de datos con el UsuarioDao
	 * @param user
	 */
	private void addUser(User user){
		try {
			dao.createUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
