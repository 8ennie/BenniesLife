package databaseDAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import database.Person;
import database.Person_;

public class PersonDao extends JpaDao<Person, Integer> implements IPersonDao{

	@Override
	public List<Person> findByLastName(String lastName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> u = cq.from(Person.class);
		cq.select(u);
		cq.where(cb.equal(u.get(Person_.lastname), lastName));
		TypedQuery<Person> q = entityManager.createQuery(cq);
		return q.getResultList();
	}

	@Override
	public List<Person> getPersonByType(int type) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> u = cq.from(Person.class);
		cq.select(u);
		cq.where(cb.equal(u.get(Person_.personType), new PersonTypeDao().findById(type)));
		TypedQuery<Person> q = entityManager.createQuery(cq);
		return q.getResultList();
	}

}
