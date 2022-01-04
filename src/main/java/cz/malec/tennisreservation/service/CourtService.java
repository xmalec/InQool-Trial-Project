/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.service;

import cz.malec.tennisreservation.model.Court;
import java.util.List;

/**
 *
 * @author Jiří Malec
 */
public interface CourtService {
    /**
     * finds all courts
     * @return list of courts
     */
    public List<Court> getAllCourts();
}
