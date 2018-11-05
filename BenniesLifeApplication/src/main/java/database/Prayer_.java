package database;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Prayer.class)
public abstract class Prayer_ {

	public static volatile SingularAttribute<Prayer, Integer> prayer_id;
	public static volatile SingularAttribute<Prayer, String> notes;
	public static volatile SingularAttribute<Prayer, Date> createdDate;
	public static volatile SingularAttribute<Prayer, Integer> prayCount;
	public static volatile SingularAttribute<Prayer, Boolean> answered;
	public static volatile SingularAttribute<Prayer, Integer> importance;
	public static volatile ListAttribute<Prayer, Person> person;
	public static volatile SingularAttribute<Prayer, Date> dueDate;
	public static volatile SingularAttribute<Prayer, String> topic;
	public static volatile SingularAttribute<Prayer, String> prayerDescription;
	public static volatile SingularAttribute<Prayer, Date> dateAnswered;

}

