package database;


import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(UserCategory.class)
public abstract class UserCategory_ {

	public static volatile SingularAttribute<UserCategory, String> catagoryName;
	public static volatile SingularAttribute<UserCategory, Integer> userCatagoryId;
	public static volatile SingularAttribute<UserCategory, String> catagoryDescription;
	public static volatile ListAttribute<UserCategory, User> user;

}

