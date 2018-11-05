/**
 * 
 */
package databaseDAO;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import database.PersonType;
import database.PersonType_;


/**
 * @author bcwie
 *
 */
public class PersonTypeDao extends JpaDao<PersonType, Integer>implements IPersonTypeDao{

	@Override
	public PersonType getPersonType(String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PersonType> cq = cb.createQuery(PersonType.class);
		Root<PersonType> cu = cq.from(PersonType.class);
		cq.select(cu);
		cq.where(cb.equal(cu.get(PersonType_.typeName), name));
		TypedQuery<PersonType> q = entityManager.createQuery(cq);
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
