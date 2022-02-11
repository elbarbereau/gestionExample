package fr.formation.inti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "LOGIN")
	@NotBlank
	@Size(min=3,max=5)
	private String login;
	
	@Column(name = "PASSWORD")
	@NotBlank
	@Size(min=5,max=7)
	private String password;
	
	@OneToOne
	@JoinColumn(name = "emp_id", nullable = false)
	private Employee emp;
	
	@Column(name = "CONNECTION_NUMBER")
	private Integer connectionNumber;
	
	
	public User() {
	}
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public User(String login, String password, Integer connectionNumber) {
		super();
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}
	public User(Integer userId, String login, String password, Integer connectionNumber) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.connectionNumber = connectionNumber;
	}
	
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	
	public Integer getConnectionNumber() {
		return connectionNumber;
	}
	
	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + ", password=" + password + ", connectionNumber="
				+ connectionNumber + "]";
	}
	
	
	
	

}
