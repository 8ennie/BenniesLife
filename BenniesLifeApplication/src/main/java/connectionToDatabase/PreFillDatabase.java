package connectionToDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import database.*;
import databaseDAO.UserCategoryDao;
import login.PasswordHandler;

public class PreFillDatabase {

	EntityManager entityManager = GetConnection.getEntityManager();
	UserCategoryDao UsCaDao = new UserCategoryDao();
	PasswordHandler passwordHandler = new PasswordHandler();
	
	public PreFillDatabase() {
			FillDatabase();
	}
	
	public void FillDatabase() {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		UserCategory administrator = new UserCategory();
		administrator.setUserCatagoryId(1);
		administrator.setCatagoryName("Admin");
		administrator.setCatagoryDescription("The User has all Permishions");
		entityManager.persist(administrator);
		
		UserCategory viewer = new UserCategory();
		viewer.setUserCatagoryId(2);
		viewer.setCatagoryName("Viewer");
		viewer.setCatagoryDescription("The User has the Permishion to View the Data");
		entityManager.persist(viewer);
		
		UserCategory powerUser = new UserCategory();
		powerUser.setUserCatagoryId(3);
		powerUser.setCatagoryName("Power User");
		powerUser.setCatagoryDescription("The User has the Permishion to View/Edit/Delete Data");
		entityManager.persist(powerUser);
		
		PersonType userType = new PersonType();
		userType.setTypeName("User");
		userType.setTypeDescription("The Person was created for a User in the System");
		entityManager.persist(userType);
		
		PersonType prayForType = new PersonType();
		prayForType.setTypeName("PrayFor");
		prayForType.setTypeDescription("The Person was created to pray for");
		entityManager.persist(prayForType);
		
		Person person = new Person();
		person.setFirstname("Benjmain");
		person.setLastname("Wiemann");
		person.addPersonType(userType);
		userType.addPerson(person);
		entityManager.persist(person);
		
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword(passwordHandler.getPassword("admin"));
		admin.setUserCategory(administrator);
		admin.setPerson(person);
		entityManager.persist(admin);
		
		transaction.commit();
	}
	
	
	
}
