/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.dao;

import cz.malec.tennisreservation.model.Reservation;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jiří Malec
 */
@Repository
public class ReservationDaoImpl extends BaseDaoImpl<Reservation> implements ReservationDao {

    public ReservationDaoImpl() {
        super.setClass(Reservation.class);
    }
    
}
