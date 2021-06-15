package com.example.demo.json;

import java.util.Date;

public class ReservationJSON {
	private Date start;
	private Date end;
	private Integer idPlayer;
	private Integer idCourt;
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Integer getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
	}
	public Integer getIdCourt() {
		return idCourt;
	}
	public void setIdCourt(Integer idCourt) {
		this.idCourt = idCourt;
	}
	
	
	
}