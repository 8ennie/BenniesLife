package databaseDAO;

import java.util.List;

import database.Person;

public interface IPersonDao extends IDao<Person,Integer>{

	public List<Person> findByLastName(String lastName) ;
	
	public List<Person> getPersonByType(int type);
	
	
}
