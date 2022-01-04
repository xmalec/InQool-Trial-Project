/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.controller;

import cz.malec.tennisreservation.form.ReservationForm;
import cz.malec.tennisreservation.model.Reservation;
import cz.malec.tennisreservation.service.ReservationService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jiří Malec
 */
@RestController
@RequestMapping("reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    /**
     * finds reservations that take place on the selected court
     * @param courtNumber
     * @return list of reservations
     */
    @GetMapping("/court-number")
    public List<Reservation> byCourtNumber(@RequestParam Integer courtNumber) {
        return reservationService.getReservationsByCourtNumber(courtNumber);
    }
    
    /**
     * finds reservations associated with phone number
     * @param phoneNumber
     * @return list of reservations
     */
    @GetMapping("/phone-number")
    public List<Reservation> findBy(@RequestParam String phoneNumber) {
        return reservationService.getReservationsByPhoneNumber(phoneNumber);
    }
    
    /**
     * processes the request to save a new reservation
     * @param form of reservation with filled values
     * @return price of saved reservation
     */
    @PostMapping("/create")
    public BigDecimal create(@RequestBody ReservationForm form) {
        Reservation reservation = reservationService.createReservation(form);
        return reservation.getPrice();
    }
}
