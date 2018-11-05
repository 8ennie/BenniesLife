package databaseDAO;

import database.PersonType;

public interface IPersonTypeDao extends IDao<PersonType,Integer>{

	public PersonType getPersonType(String name);
	
}
