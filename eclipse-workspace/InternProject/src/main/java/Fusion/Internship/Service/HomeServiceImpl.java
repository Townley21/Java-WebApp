package Fusion.Internship.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import Fusion.Internship.DAO.BasicDAO;
import Fusion.Internship.Model.User;

@Primary
@Service
public  class HomeServiceImpl implements HomeService {
	
	@Autowired
	BasicDAO dao;
	
	//TODO add business logic
	
	@Override
	public List<User> getAllUsers() throws SQLException {
		return dao.getAllUsers();
	}
	
	@Override
	public User createUser(User user) throws SQLException {
		return dao.createUser(user);
		
	}
	
	@Override
	public User getUser(String email) throws SQLException {
		return dao.getUser(email);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		dao.updateUser(user);
	}

	@Override
	public void printUser(User user) {
		dao.printUser(user);
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		dao.deleteUser(id);
	}
	
	
	
}
