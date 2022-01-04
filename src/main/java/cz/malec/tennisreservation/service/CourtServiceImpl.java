/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.service;

import cz.malec.tennisreservation.dao.CourtDao;
import cz.malec.tennisreservation.model.Court;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jiří Malec
 */
@Service
public class CourtServiceImpl implements CourtService {
    
    @Autowired
    private CourtDao courtDao;
    
    public List<Court> getAllCourts() {
        return courtDao.all();
    }
}
