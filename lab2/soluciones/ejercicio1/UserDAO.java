/**
 * 
 */
package es.uc3m.tiw.lab2.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import es.uc3m.tiw.lab1.dominios.User;

/**
 * @author David Palomar
 *
 */
public interface UserDAO {
	
	public abstract User updateUser(User user) throws SQLException;

	public abstract void deleteUser(User user) throws SQLException;

	public abstract User createUser(User newUser) throws SQLException;

	public abstract User getUserByName(String name) throws SQLException;

	public abstract User getUserByKey(int pk) throws SQLException;

	public abstract Collection<User> listUsers() throws SQLException;

	public abstract void setConnection(Connection con);

	public abstract void setQuerys(ResourceBundle rb);
}
