package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public  class UserCategory {

	@Id
	private int userCatagoryId;
	@Column
	private String catagoryName;
	@Column
	private String catagoryDescription;
	@OneToMany(mappedBy="userCategory")
	private List<User> user = new ArrayList<User>();
	
	
	public void setUser(User u) {
		u.setUserCategory(this);
		this.user.add(u);
	}
	public int getUserCatagoryId() {
		return userCatagoryId;
	}
	public void setUserCatagoryId(int userCatagoryId) {
		this.userCatagoryId = userCatagoryId;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getCatagoryDescription() {
		return catagoryDescription;
	}
	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}
	
	
}
