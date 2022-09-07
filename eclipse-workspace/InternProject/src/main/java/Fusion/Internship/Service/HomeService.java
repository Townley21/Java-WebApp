package Fusion.Internship.Service;

import java.sql.SQLException;
import java.util.List;

import Fusion.Internship.Model.User;

public interface HomeService {
	
	public User createUser(User user) throws SQLException;
	
	public User getUser(String email) throws SQLException;
	
	public void updateUser(User user) throws SQLException;
	
	public void printUser(User user);
	
	public void deleteUser(int id) throws SQLException;
	
	public List<User> getAllUsers() throws SQLException;
	
}
