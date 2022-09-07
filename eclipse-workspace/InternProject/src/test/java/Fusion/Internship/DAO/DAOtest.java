package Fusion.Internship.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import Fusion.Internship.Model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@ImportResource("classpath:spring-beans.xml")
class DAOtest {
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	public int id = 1;
	public String email = "admin@gmail.com";
	public String password = "admin";
	public boolean admin = true;
	public User user = new User(id, email, password, timestamp, admin, null, null, null, null);
	
	BasicDAOImpl dao = new BasicDAOImpl();
	
	@Test
	void testGetAllUsers() throws SQLException {
		System.out.println("Testing get all users...");
		for(int i = 0; i < dao.getAllUsers().size(); i++) {
			System.out.println("ID: " + dao.getAllUsers().get(i).getID());
			System.out.println("Email: " + dao.getAllUsers().get(i).getEmail());
			System.out.println("Password: " + dao.getAllUsers().get(i).getPassword());
			System.out.println("Timestamp: " + dao.getAllUsers().get(i).getLastLogin());
			System.out.println("Admin Status: " + dao.getAllUsers().get(i).getAdminStatus() + "\n");
		}
		
		assertNotEquals(dao.getAllUsers().size(), 0);

	}
	
	
	
	@Test
	void testCreateUser() throws SQLException {
		System.out.println("Testing create user...");
		dao.createUser(user);
		dao.printUser(user);
		
		assertEquals(email, dao.getUser(user.getEmail()));
	}
	
	@Test
	void testGetUser() throws SQLException {
		System.out.println("Testing get user...");
		
		User tempUser = dao.getUser(user.getEmail());
		
		
		assertEquals(tempUser.getEmail(), email);
		assertEquals(tempUser.getPassword(), password);
		
	}
	
	@Test
	void testUpdateUser() throws SQLException {
		System.out.println("Testing update user...");
		
		user.setEmail("admin@gmail.com");
		//user.setPassword("admin");
		
		dao.updateUser(user);
		dao.printUser(user);
		
		assertEquals(dao.getUser(user.getEmail()).getEmail(), "newEmail@gmail.com");
	}
	
	@Test
	void testDeleteUser() throws SQLException {
		System.out.println("Testing delete user...");
		
		dao.deleteUser(user.getID());
		
		assertNull(dao.getUser(user.getEmail()));
	}

}
