/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Jiří Malec
 */

@Entity
public class CourtSurface extends Persistence{
    
    @Column
    private BigDecimal pricePerMinute;
    
    @Column
    private String name;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courtSurface")
    private List<Court> courts;

    public BigDecimal getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(BigDecimal pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Court> getCourts() {
        return courts;
    }

    public void setCourts(List<Court> courts) {
        this.courts = courts;
    }

    
    
}
