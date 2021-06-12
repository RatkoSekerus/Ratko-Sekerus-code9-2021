package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TennisAdmin database table.
 * 
 */
@Entity
@NamedQuery(name="TennisAdmin.findAll", query="SELECT t FROM TennisAdmin t")
public class TennisAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminID;

	private String password;

	private String userName;

	public TennisAdmin() {
	}

	public int getAdminID() {
		return this.adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}