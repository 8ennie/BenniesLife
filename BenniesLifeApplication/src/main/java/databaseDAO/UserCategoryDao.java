package databaseDAO;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import database.UserCategory;
import database.UserCategory_;


public class UserCategoryDao extends JpaDao<UserCategory, Integer>implements IUserCategoryDao {

	@Override
	public UserCategory getCategory(String categoryName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserCategory> cq = cb.createQuery(UserCategory.class);
		Root<UserCategory> cu = cq.from(UserCategory.class);
		cq.select(cu);
		cq.where(cb.equal(cu.get(UserCategory_.catagoryName), categoryName));
		TypedQuery<UserCategory> q = entityManager.createQuery(cq);
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
