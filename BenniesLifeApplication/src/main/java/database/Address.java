/**
 * 
 */
package database;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;
	
	@Column(nullable=false)
	private String streetName;
	
	@Column(nullable=false)
	private String postalCode;
	
	@Column(nullable=false)
	private String city;
	
	@Column(nullable=false)
	private String country;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Person> person;
	
	
	

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public int getAddress_id() {
		return address_id;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
