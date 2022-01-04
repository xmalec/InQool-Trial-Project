/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author JiříMalec
 */
@MappedSuperclass
public class Persistence {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;
    
    public Persistence() {
    }

    public Integer getId() {
        return id;
    }
}