package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Person {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int person_id;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<PersonType> personType = new ArrayList<PersonType>();
	@Column(nullable=false)
	private String lastname;
	@Column(nullable=false)
	private String firstname;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Column()
	private String emailadress;
	@Column()
	private String phoneNumber;
	@Column()
	private String gender;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<User> user;
	@Column()
	private int age;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Address address;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Prayer> prayer = new ArrayList<Prayer>();
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmailadress() {
		return emailadress;
	}
	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<User> getUser() {
		return this.user;
	}
	public void setUser(User newUser) {
		this.user.add(newUser);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<PersonType> getPersonType() {
		return personType;
	}
	public void addPersonType(PersonType personType) {
		this.personType.add(personType);
	}
	public List<Prayer> getPrayer() {
		return prayer;
	}
	public void setPrayer(Prayer prayer) {
		this.prayer.add(prayer);
	}
	
}
