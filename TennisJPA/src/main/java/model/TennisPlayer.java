package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TennisPlayer database table.
 * 
 */
@Entity
@NamedQuery(name="TennisPlayer.findAll", query="SELECT t FROM TennisPlayer t")
public class TennisPlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerID;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String email;

	private String firstName;

	private String lastName;

	//bi-directional many-to-one association to TennisReservation
	@OneToMany(mappedBy="tennisPlayer")
	private List<TennisReservation> tennisReservations;

	public TennisPlayer() {
	}

	public int getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<TennisReservation> getTennisReservations() {
		return this.tennisReservations;
	}

	public void setTennisReservations(List<TennisReservation> tennisReservations) {
		this.tennisReservations = tennisReservations;
	}

	public TennisReservation addTennisReservation(TennisReservation tennisReservation) {
		getTennisReservations().add(tennisReservation);
		tennisReservation.setTennisPlayer(this);

		return tennisReservation;
	}

	public TennisReservation removeTennisReservation(TennisReservation tennisReservation) {
		getTennisReservations().remove(tennisReservation);
		tennisReservation.setTennisPlayer(null);

		return tennisReservation;
	}

}