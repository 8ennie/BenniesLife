package databaseDAO;

import database.User;

public interface IUserDao extends IDao<User,String>{

	public User findByUsername(String username);
	public String getPassword(String username);
	
}
