/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Jiří Malec
 */

@Entity
public class Court extends Persistence{
    @Column(unique=true)
    private Integer courtNumber;
    
    @ManyToOne
    private CourtSurface courtSurface;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "court")
    private List<Reservation> reservations;

    public Integer getCourtNumber() {
        return courtNumber;
    }

    public void setCourtNumber(Integer courtNumber) {
        this.courtNumber = courtNumber;
    }

    

    public CourtSurface getCourtSurface() {
        return courtSurface;
    }

    public void setCourtSurface(CourtSurface courtSurface) {
        this.courtSurface = courtSurface;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
}
