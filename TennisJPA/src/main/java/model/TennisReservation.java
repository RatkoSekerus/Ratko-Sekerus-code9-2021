package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TennisReservation database table.
 * 
 */
@Entity
@NamedQuery(name="TennisReservation.findAll", query="SELECT t FROM TennisReservation t")
public class TennisReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reservationID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStart;

	//bi-directional many-to-one association to TennisCourt
	@ManyToOne
	@JoinColumn(name="courtID")
	private TennisCourt tennisCourt;

	//bi-directional many-to-one association to TennisPlayer
	@ManyToOne
	@JoinColumn(name="playerID")
	private TennisPlayer tennisPlayer;

	public TennisReservation() {
	}

	public int getReservationID() {
		return this.reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public TennisCourt getTennisCourt() {
		return this.tennisCourt;
	}

	public void setTennisCourt(TennisCourt tennisCourt) {
		this.tennisCourt = tennisCourt;
	}

	public TennisPlayer getTennisPlayer() {
		return this.tennisPlayer;
	}

	public void setTennisPlayer(TennisPlayer tennisPlayer) {
		this.tennisPlayer = tennisPlayer;
	}

}