package database;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PersonType.class)
public abstract class PersonType_ {

	public static volatile SingularAttribute<PersonType, Integer> personType_id;
	public static volatile ListAttribute<PersonType, Person> person;
	public static volatile SingularAttribute<PersonType, String> typeName;
	public static volatile SingularAttribute<PersonType, String> typeDescription;

}

