/**
 * 
 */
package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author bcwie
 *
 */
@Entity
public class PersonType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personType_id;
	
	@Column
	private String typeName;
	
	@Column
	private String typeDescription;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Person> person = new ArrayList<Person>();

	public String getTypeName() {
		return typeName;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public void addPerson(Person person) {
		this.person.add(person);
	}

	public int getPerosnTypeId() {
		return this.personType_id;
	}
	
	
	
}
