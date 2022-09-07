package Fusion.Internship.Model;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	Date date = new Date();
	long time = date.getTime();
	
	private int id;
	private String email;
	private Timestamp lastLogin = new Timestamp(time);
	private String password;
	private boolean admin;
	private Integer age;
	private String gender;
	private String securityQuestion;
	private String securityAnswer;
	
	public User(int id, String email, String password, Timestamp lastLogin, boolean admin,  Integer age, String gender, String securityQuestion, String securityAnswer) {
		super();
		this.email = email;
		this.id = id;
		this.password = password;
		this.lastLogin = lastLogin;
		this.admin = admin;
		this.age = age;
		this.gender = gender;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	public int getID() {
		return id;
	}
	
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public boolean getAdminStatus() {
		return admin;
	}
	
	public void setAdminStatus(boolean admin) {
		this.admin = admin;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

}
