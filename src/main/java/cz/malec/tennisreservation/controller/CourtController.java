/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.controller;

import cz.malec.tennisreservation.model.Court;
import cz.malec.tennisreservation.service.CourtService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jiří Malec
 */
@RestController
@RequestMapping("court")
public class CourtController {
    
    @Autowired
    private CourtService courtService;
    
    /**
     * finds all courts
     * @return list of courts
     */
    @GetMapping("")
    public List<Court> all() {
        return courtService.getAllCourts();
    }
}
