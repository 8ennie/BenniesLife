package databaseDAO;

import java.io.Serializable;
import java.util.List;

public interface IDao<E, PK extends Serializable>{

	public void persist(E entity);
	
	public void remove(E entity);
	
	public E findById(PK id);
	
	public List<E> getAll();
	
}
