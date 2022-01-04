/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.form;

import cz.malec.tennisreservation.model.GameType;
import java.time.LocalDateTime;

/**
 *
 * @author Jiří Malec
 */
public class ReservationForm {
    
    private Integer courtNumber;
    private String phoneNumber;
    private String clientName;
    private GameType gameType;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;

    public Integer getCourtNumber() {
        return courtNumber;
    }

    public void setCourtNumber(Integer courtNumber) {
        this.courtNumber = courtNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
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
