package Fusion.Internship.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Fusion.Internship.Model.User;


public class BasicDAOImpl implements BasicDAO {
	
	//SQL statements
	final static String CREATE_USER_SQL = "INSERT INTO userinfo " + "(id, email, password, lastlogin, admin, age, gender, securityQuestion, securityAnswer) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ? ,?);";
	final static String SELECT_USER_BY_EMAIL = "SELECT * FROM userinfo WHERE email = ?;";
	final static String UPDATE_USERS_SQL = "UPDATE userinfo SET email = ?, password = ?, lastLogin = ?, age = ?, gender = ?, securityQuestion = ?, securityAnswer = ?, WHERE id = ?;";
	final static String DELETE_USER_SQL = "DELETE FROM userinfo WHERE id = ?;";
	final static String GET_ALL_USERS = "SELECT * FROM userinfo;";
	
	
	 public Connection connectdb() throws SQLException {
		
			Connection conn = Fusion.Internship.Database.DatabaseManager.openConnection();
			
			return conn;

	}
	 
	 @Override
	 public List<User> getAllUsers() throws SQLException {
		 
		 Connection connection = connectdb();
		 PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
		 List<User> userList = new ArrayList<>();
		 
		 //VARIABLE NAMES MUST EXACTLY MATCH GETTERS/SETTERS IN MODEL
		 int id;
		 String email;
		 String password;
		 Timestamp lastlogin;
		 boolean adminStatus;
		 Integer age;
		 String gender;
		 String securityQuestion;
		 String securityAnswer;
		 
		 ResultSet rs = preparedStatement.executeQuery();
		 
		 while(rs.next()) {
			 	id = rs.getInt("id");
				email = rs.getString("email");
				password = rs.getString("password");
				lastlogin = rs.getTimestamp("lastLogin");
				adminStatus = rs.getBoolean("admin");
				age = rs.getInt("age");
				gender = rs.getString("gender");
				securityQuestion = rs.getString("securityQuestion");
				securityAnswer = rs.getString("securityAnswer");
				
				userList.add(new User(id, email, password, lastlogin, adminStatus, age, gender, securityQuestion, securityAnswer));
		 }
		 
		return userList;
		 
	 }
	
	
	@Override
	public User createUser(User user) throws SQLException {
		
		Integer age = user.getAge();
		String gender = user.getGender();
		String securityQuestion = user.getSecurityQuestion();
		String securityAnswer = user.getSecurityAnswer();;
		
		Connection connection = connectdb();
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_SQL);
		preparedStatement.setLong(1, user.getID());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setTimestamp(4, user.getLastLogin());
		preparedStatement.setBoolean(5, user.getAdminStatus());
		
		if(age == null) 				preparedStatement.setNull(6, java.sql.Types.NULL);
		else 							preparedStatement.setLong(6, user.getAge());
	
		if(gender == null) 				preparedStatement.setNull(7, java.sql.Types.NULL);
		else							preparedStatement.setString(7, user.getGender());
		
		if(securityQuestion == null) 	preparedStatement.setNull(8, java.sql.Types.NULL);
		else							preparedStatement.setString(8, user.getSecurityQuestion());
		
		if(securityAnswer == null)		preparedStatement.setNull(9, java.sql.Types.NULL);
		else							preparedStatement.setString(9, user.getSecurityAnswer());
		
		preparedStatement.executeUpdate();
		return user;
		
	}
	
	@Override
	public User getUser(String email) throws SQLException {
		User user = null;
		int userID;
		String password;
		Timestamp lastLogin;
		boolean admin;
		Integer age;
		String gender;
		String securityQuestion;
		String securityAnswer;
		
		Connection connection = connectdb();
		
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);
		preparedStatement.setString(1, email);
		
		System.out.println(preparedStatement);
			
		ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				userID = rs.getInt("id");
				email = rs.getString("email");
				password = rs.getString("password");
				lastLogin = rs.getTimestamp("lastLogin");
				admin = rs.getBoolean("admin");
				age = rs.getInt("age");
				gender = rs.getString("gender");
				securityQuestion = rs.getString("securityQuestion");
				securityAnswer = rs.getString("securityAnswer");
				
				
				user = new User(userID, email, password, lastLogin, admin, age, gender, securityQuestion, securityAnswer);
			}
			
		
		return user;
	}
	
	@Override
	public void updateUser(User user) throws SQLException {
		
		Connection connection = connectdb();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setTimestamp(3, user.getLastLogin());
		preparedStatement.setInt(4, user.getID());
		preparedStatement.setBoolean(5, user.getAdminStatus());
		preparedStatement.setInt(6, user.getAge());
		preparedStatement.setString(7, user.getGender());
		preparedStatement.setString(8, user.getSecurityQuestion());
		preparedStatement.setString(9, user.getSecurityAnswer());
		preparedStatement.executeUpdate();

	}
	
	@Override
	public void printUser(User user) {
		int id = user.getID();
		String email = user.getEmail();
		String password = user.getPassword();
		Timestamp lastLogin = user.getLastLogin();
		boolean admin = user.getAdminStatus();
		Integer age = user.getAge();
		String gender = user.getGender();
		String securityQuestion = user.getSecurityQuestion();
		String securityAnswer = user.getSecurityAnswer();
		
		
		System.out.println();
		System.out.println("============ User Details =============");
		System.out.println("ID:\t" + id);
		System.out.println("Email:\t" + email);
		System.out.println("Password:\t" + password);
		System.out.println("Lastlogin:\t" + lastLogin);
		System.out.println("Admin Status:\t" + admin);
		System.out.println("Age:\t" + age);
		System.out.println("Gender:\t" + gender);
		System.out.println("Security Question:\t" + securityQuestion);
		System.out.println("Secuirty Answer:\t" + securityAnswer);
		System.out.println("========================================");
		
	}
	
	@Override
	public void deleteUser(int id) throws SQLException {
		
		try(Connection connection = connectdb();
			PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
			statement.setInt(1, id);
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
