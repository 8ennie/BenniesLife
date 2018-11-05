package database;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, Date> birthday;
	public static volatile SingularAttribute<Person, String> firstname;
	public static volatile SingularAttribute<Person, String> phoneNumber;
	public static volatile SingularAttribute<Person, Address> address;
	public static volatile SingularAttribute<Person, String> emailadress;
	public static volatile SingularAttribute<Person, String> gender;
	public static volatile ListAttribute<Person, Prayer> prayer;
	public static volatile ListAttribute<Person, PersonType> personType;
	public static volatile ListAttribute<Person, User> user;
	public static volatile SingularAttribute<Person, Integer> age;
	public static volatile SingularAttribute<Person, Integer> person_id;
	public static volatile SingularAttribute<Person, String> lastname;

}

