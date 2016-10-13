/**
 * 
 */
package es.uc3m.tiw.lab2.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import es.uc3m.tiw.lab1.dominios.Usuario;

/**
 * @author David Palomar
 *
 */
public class UserDAOImpl implements UserDAO {

	private Connection con;
	private ResourceBundle rb;
        
	@Override
	public Collection<User> listUsers() throws SQLException{
		Statement st = con.createStatement();
		ResultSet resultados = st.executeQuery(rb.getString("listUsers"));
		
		List<User> listUsers = new ArrayList<User>();
		User user;
		while (resultados.next()) {
			user = new User();
			user.setId(resultados.getInt("id"));
			user.setName(resultados.getString("name"));
			user.setPassword(resultados.getString("password"));
			listUsers.add(user);
		}
		return listUsers;
	}
	@Override
	public User getUserByKey(int pk) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("getUserByKey"));
		ps.setInt(1, pk);
		User user = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			user = new User();
			user.setId(resultados.getInt("id"));
			user.setName(resultados.getString("name"));
			user.setPassword(resultados.getString("password"));
			
		}
		return user;
	}
	@Override
	/**
	 * Se asume que el campo nombre es unique y por tanto solo recuperará un usuario en caso de existir
	 */
	public User getUserByName(String name) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("getUserByName"));
		ps.setString(1, name);
		User user = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			user = new User();
			user.setId(resultados.getInt("id"));
			user.setName(resultados.getString("name"));
			user.setPassword(resultados.getString("password"));
			
		}
		return user;
	}
	@Override
	public User createUser(User newUser) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("createUser"));
		ps.setString(1, newUser.getName());
		ps.setString(2, newUser.getPassword());
		ps.execute();
		
		return getUserByName(newUser.getName());
	}
	@Override
	public void deleteUser(User user) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("deleteUser"));
		ps.setInt(1, user.getId());
		ps.execute();
		
	}
	@Override
	public User updateUser(User user) throws SQLException{
		PreparedStatement ps = con.prepareStatement(rb.getString("updateUser"));
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getId());
		ps.execute();
		return getUserByKey(user.getId());
		
	}
	@Override
	public void setConnection(Connection con) {
		this.con = con;
		
	}
	@Override
	public void setQuerys(ResourceBundle rb) {
		this.rb = rb;
		
	}

}

