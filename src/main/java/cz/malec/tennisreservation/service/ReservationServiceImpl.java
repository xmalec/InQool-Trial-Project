/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.service;

import cz.malec.tennisreservation.dao.ClientDao;
import cz.malec.tennisreservation.dao.CourtDao;
import cz.malec.tennisreservation.dao.ReservationDao;
import cz.malec.tennisreservation.exception.InvalidInputException;
import cz.malec.tennisreservation.form.ReservationForm;
import cz.malec.tennisreservation.model.Client;
import cz.malec.tennisreservation.model.Court;
import cz.malec.tennisreservation.model.Reservation;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jiří Malec
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    
    @Autowired
    private ReservationDao reservationDao;
    
    @Autowired
    private CourtDao courtDao;
    
    @Autowired
    private ClientDao clientDao;
    
    @Override
    public List<Reservation> getReservationsByCourtNumber(Integer courtNumber) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put("court.courtNumber", courtNumber.toString());
        return reservationDao.findBy(criteria);
    }
    
    @Override
    public List<Reservation> getReservationsByPhoneNumber(String phoneNumber) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put("client.phoneNumber", phoneNumber);
        return reservationDao.findBy(criteria);
    }
    
    @Transactional
    @Override
    public Reservation createReservation(ReservationForm form) {
        Reservation reservation = new Reservation();
        if(form.getGameType() == null) {
            throw new InvalidInputException("Missing gameType parameter!");
        }
        reservation.setGameType(form.getGameType());
        Map<String, String> criteria = new HashMap<>();
        criteria.put("courtNumber", form.getCourtNumber().toString());
        Court court = courtDao.findOneBy(criteria);
        if(court == null) {
            throw new InvalidInputException("Invalid courtNumber parameter!");
        }
        reservation.setCourt(court);
        if(form.getPhoneNumber() == null) {
            throw new InvalidInputException("Missing phoneNumber parameter!");
        }
        criteria = new HashMap<>();
        criteria.put("phoneNumber", form.getPhoneNumber());
        Client client = clientDao.findOneBy(criteria);
        if(client == null) {
            client = new Client();
            if(form.getClientName() == null) {
                throw new InvalidInputException("Missing clientName parameter!");
            }
            client.setName(form.getClientName());
            client.setPhoneNumber(form.getPhoneNumber());
            clientDao.create(client);
        }
        if(form.getFromTime() == null) {
            throw new InvalidInputException("Missing fromTime parameter!");
        }
        if(form.getToTime() == null) {
            throw new InvalidInputException("Missing toTime parameter!");
        }
        reservation.setClient(client);
        reservation.setFromTime(form.getFromTime());
        reservation.setToTime(form.getToTime());
        reservation.setPrice(calculatePriceOfReservation(reservation));
        reservationDao.create(reservation);
        return reservation;
    }
    
    private static BigDecimal calculatePriceOfReservation(Reservation reservation) {
        Duration duration = Duration.between(reservation.getFromTime(),reservation.getToTime());
        BigDecimal price = new BigDecimal(duration.toMinutes()).multiply(reservation.getCourt().getCourtSurface().getPricePerMinute());
        return price;
    }
}
