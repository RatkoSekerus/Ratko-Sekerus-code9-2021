package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TennisCourt database table.
 * 
 */
@Entity
@NamedQuery(name="TennisCourt.findAll", query="SELECT t FROM TennisCourt t")
public class TennisCourt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courtID;

	private String name;

	//bi-directional many-to-one association to TennisReservation
//	@OneToMany(mappedBy="tennisCourt")
//	private List<TennisReservation> tennisReservations;

	public TennisCourt() {
	}

	public int getCourtID() {
		return this.courtID;
	}

	public void setCourtID(int courtID) {
		this.courtID = courtID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public List<TennisReservation> getTennisReservations() {
		return this.tennisReservations;
	}

	public void setTennisReservations(List<TennisReservation> tennisReservations) {
		this.tennisReservations = tennisReservations;
	}

	public TennisReservation addTennisReservation(TennisReservation tennisReservation) {
		getTennisReservations().add(tennisReservation);
		tennisReservation.setTennisCourt(this);

		return tennisReservation;
	}

	public TennisReservation removeTennisReservation(TennisReservation tennisReservation) {
		getTennisReservations().remove(tennisReservation);
		tennisReservation.setTennisCourt(null);

		return tennisReservation;
	}
*/
}