/**
 * 
 */
package es.uc3m.tiw.lab1.domains;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import es.uc3m.tiw.lab2.domains.Address;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

/**
 * @author David Palomar
 *
 */
@Entity
@Table(name="USERS")
@XmlRootElement
public class User {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(nullable = false, length = 15)
	private String name;
	@Column(length = 30)
	private String lastName;
	@Column(nullable = false, length = 10, unique = true)
	private String user;
	@Column(nullable = false)
	private String password;
	
	@OneToOne(cascade = ALL)
	private Address address;
	private Integer age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String lastName, String user,
			String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.
			= user;
		this.password = password;
	}
	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	/**
	 * @param age
	 * @param name2
	 */
	public User(Integer age, String name) {
		this.setEdad(age);
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the address
	 */
	public Direccion getAddress() {
		return address;
	}
	/**
	 * @param direccion the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param edad the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
