/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.service;

import cz.malec.tennisreservation.form.ReservationForm;
import cz.malec.tennisreservation.model.Reservation;
import java.util.List;

/**
 *
 * @author Jiří Malec
 */
public interface ReservationService {
    /**
     * finds reservations that take place on the selected court
     * @param courtNumber - unique name of the court
     * @return List of reservations
     */
    public List<Reservation> getReservationsByCourtNumber(Integer courtNumber);
    
    /**
     * finds reservations associated with phone number
     * @param phoneNumber - phone number of the client
     * @return List of reservations
     */
    public List<Reservation> getReservationsByPhoneNumber(String phoneNumber);
    
    /**
     * creates and saves new reservation
     * @param form of reservation with filled values
     * @return saved reservation
     */
    public Reservation createReservation(ReservationForm form);
}
