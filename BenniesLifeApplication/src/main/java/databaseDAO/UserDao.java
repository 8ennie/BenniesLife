package databaseDAO;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import database.User;
import database.User_;


public class UserDao extends JpaDao<User, String>implements IUserDao {

	@Override
	public User findByUsername(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> u = cq.from(User.class);
		cq.select(u);
		cq.where(cb.equal(u.get(User_.username), username));
		TypedQuery<User> q = entityManager.createQuery(cq);
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		 
					
	}

	@Override
	public String getPassword(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> u = cq.from(User.class);
		cq.select(u);
		cq.where(cb.equal(u.get(User_.username), username));
		TypedQuery<User> q = entityManager.createQuery(cq);
	
		User user = new User();
		try {
			user = q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return user.getPassword();
	}

	

	

}
