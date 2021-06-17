package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.json.ReservationJSON;
import com.example.demo.repository.ReservationRepository;

import listeners.Listeners;
import model.TennisCourt;
import model.TennisPlayer;
import model.TennisReservation;

@Service
public class ReservationService {
	
	private List<Listeners> listeners;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public TennisReservation addReservation(TennisReservation r) {
		Date start = r.getDateStart();
		Date end = r.getDateEnd();
	
		if (!checkDuration(start,end)) {
			return null;
		}
		if (new Date().after(end)) {
		    return null;
		}
		if (!checkWorkTime(start,end)) {
			
			System.out.println("doesnt work");
			return null;
		} 
		if (overlapping(start,end)) {
			System.out.println("taken");
			return null;
		}	
		if(reservedToday(r.getTennisPlayer().getPlayerID(),start)) {
			System.out.println("reserved");
			return null;
		}
		if(needsToPay(r)) {
			System.out.println("needs to pay");
			return null;
		}
		
		return reservationRepository.save(r);
		
	}
	private boolean needsToPay(TennisReservation tr) {
		Integer playerID = tr.getTennisPlayer().getPlayerID();
		int slots = (int) ((Collection<TennisReservation>) reservationRepository.findAll()).stream()
				.filter(r-> {return r.getTennisPlayer().getPlayerID() == playerID;})
				.count();
	//	int payed = tr.getTennisPlayer().getMoney();
		
	/*	if ( slots >= 5 && payed < 10 ) {
		return true;
		} */
		return false;
	}
	public List<TennisReservation> reservations() {
		return (List<TennisReservation>) reservationRepository.findAll();
	}
	
	private boolean reservedToday(Integer idPlayer,Date start) {
		System.out.println("rsrvd2");
		List<TennisReservation> l = reservations();
		System.out.println("rsrvd2222");
		TennisReservation tr = l.stream()
		.filter(r-> r.getTennisPlayer().getPlayerID()==idPlayer)
		.filter(r-> r.getDateStart().getYear() == start.getYear())
		.filter(r-> r.getDateStart().getMonth() == start.getMonth())
		.filter(r-> r.getDateStart().getDay() == start.getDay())
		.findAny()
		.orElse(null);
		if (tr == null) {
			return false;
		}
		return true;
	}
	private boolean overlapping(Date start,Date end) {
		TennisReservation tr = ((Collection<TennisReservation>) reservationRepository.findAll()).stream()
				.filter(r-> r.getDateEnd().getYear()==end.getYear())
				.filter(r-> r.getDateEnd().getMonth() == end.getMonth())
				.filter(r-> r.getDateEnd().getDay()== end.getDay())
				.filter(r-> !checkOverlapping(start,end,r))
				.findFirst()
				.orElse(null);
		
		if ( tr == null ) {
			return false;
		} else {
			return true;
		}
	}
	private  boolean checkOverlapping(Date start,Date end,TennisReservation tr) {
		if ( start.getHours() == tr.getDateStart().getHours()) {
			
		return false;
		}
		if ( (start.getHours() == tr.getDateEnd().getHours()) && (start.getMinutes() < tr.getDateEnd().getMinutes()) ) {
		
			return false;
		}
		if ( (start.getHours() < tr.getDateEnd().getHours()) && (start.getHours() > tr.getDateStart().getHours())) {
			
			return false;
		}
		if ((start.getHours() < tr.getDateStart().getHours()) && (end.getHours()> tr.getDateStart().getHours()) ) {
			
			return false;
		}
		return true;
	}
	private boolean checkWorkTime(Date start,Date end) {
		if( end.getDay()==1 || end.getDay()==2 || end.getDay()==3 || end.getDay()==4 || end.getDay()==5 ) {
			if ( start.getHours() < 18 ||  end.getHours() > 23) {
			
				return false;
			}
			if ( end.getHours() == 23 && end.getMinutes() > 0) {
				
				return false;
			}
		} else {
			if ( start.getHours() < 17 ||  end.getHours() > 22) {
			
				return false;
			}
			if ( end.getHours() == 22 && end.getMinutes() > 0) {
				
				return false;
			}
		}
		
		return true;
	}

	private boolean checkDuration(Date start, Date end) {
		if (start.getDay() != end.getDay()) {
		
			return false;
		}
		if ( start.getYear() != end.getYear()) {
	
			return false;
		}
		if ( start.getMonth() != end.getMonth()) {
			
			return false;
		}
		int duration = Math.abs(start.getHours()-end.getHours());
		if ( duration > 2 ) {
		
			return false;
		} else if (duration == 2) {
			if ( end.getMinutes() > start.getMinutes() ) {
				
				return false;
			}
		}
		return true;
	}
	public TennisReservation getReservation(ReservationJSON reservationJson) {
		TennisReservation tr = new TennisReservation();
		tr.setDateStart(reservationJson.getStart());
		tr.setDateEnd(reservationJson.getEnd());
		TennisPlayer tp =  restTemplate.getForObject("http://localhost:8082/playerService/playerController/"+reservationJson.getIdPlayer(),TennisPlayer.class);
		tr.setTennisPlayer(tp);
		TennisCourt tc = restTemplate.getForObject("http://localhost:8081/courtService/courtController/"+reservationJson.getIdCourt(),TennisCourt.class);
		tr.setTennisCourt(tc);
		return tr;
	}
	
	public void deletReservationById(Integer id) {
		reservationRepository.deleteById(id);
	}
	public void notifyListeners() {
		if (listeners != null ) {
			for ( Listeners l : listeners) {
				l.sendNotification();
			}
		}
	}
}
