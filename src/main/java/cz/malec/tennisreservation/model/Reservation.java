/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jiří Malec
 */

@Entity
public class Reservation extends Persistence{
   
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Court court;
    
    @Column(nullable = false)
    @Convert(converter = GameTypeConverter.class)
    private GameType gameType;
    
    @Column
    private BigDecimal price;
    
    @Column
    private LocalDateTime fromTime;
    
    @Column
    private LocalDateTime toTime;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }
    
    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }
    
    

    
    
}
