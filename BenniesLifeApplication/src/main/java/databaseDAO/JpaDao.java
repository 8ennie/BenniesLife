package databaseDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import connectionToDatabase.GetConnection;




public abstract class JpaDao<E, PK extends Serializable> implements IDao<E, PK> {

	protected Class<E> entityClass;
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public JpaDao() {
		this.entityManager = GetConnection.getEntityManager();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public List<E> getAll(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(entityClass);
		Root<E> u = cq.from(entityClass);
		cq.select(u);
		TypedQuery<E> q = entityManager.createQuery(cq);
		return q.getResultList();
	}
	
	@Override
	public E findById(PK id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public void persist(E entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(entity);
		tx.commit();
	}

	public void merge(E entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(entity);
		tx.commit();
	}
	
	@Override
	public void remove(E entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(entity);
		tx.commit();
	}

	
}
