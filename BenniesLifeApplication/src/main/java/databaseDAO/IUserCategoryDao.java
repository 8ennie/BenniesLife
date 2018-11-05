package databaseDAO;


import database.UserCategory;

public interface IUserCategoryDao extends IDao<UserCategory,Integer> {

	public UserCategory getCategory(String userCategory);
	
	
}
