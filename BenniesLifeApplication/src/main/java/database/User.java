package database;



import java.util.Date;

import javax.persistence.*;


@Entity
public class User{

	
	@Id@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private UserCategory userCategory;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Person person;
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	


	
}
