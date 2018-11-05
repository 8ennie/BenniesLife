package database;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Date> createdDate;
	public static volatile SingularAttribute<User, UserCategory> userCategory;
	public static volatile SingularAttribute<User, Person> person;
	public static volatile SingularAttribute<User, String> username;

}

