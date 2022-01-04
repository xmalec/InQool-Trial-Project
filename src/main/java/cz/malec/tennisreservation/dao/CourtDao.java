/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.dao;

import cz.malec.tennisreservation.model.Court;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jiří Malec
 */
@Repository
public interface CourtDao extends BaseDao<Court> {
    
}
