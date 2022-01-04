/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.dao;

import cz.malec.tennisreservation.model.Persistence;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * Base dao class with CRUD operations
 * @param <T> 
 * @author Jiří Malec
 */
@Repository
public interface BaseDao<T> {
    /**
     * saves the persistance
     * @param entity persistence to save
     * @return id of saved persistence
     */
    public Integer create(Persistence entity);

    /**
     * updates the persistance
     * @param entity persistence to update
     */
    public void update(Persistence entity);
    
    /**
     * removes the persistence
     * @param entity persistence to delete
     */
    public void delete(Persistence entity);

    /**
     * finds and returns the object with the sent id
     * @param id
     * @return persistence
     */
    public T find(Integer id);

    /**
     * finds all persistences
     * @return List of persistences
     */
    public List<T> all();
    
    /**
     * finds and orders all persistences
     * @param orderBy the attribute to sort by
     * @param direction DESC || ASC
     * @return sorted persistences
     */
    public List<T> all(String orderBy, String direction);
    
    /**
     * finds all persistences that match the parameters
     * @param criteria Map of attributes and values
     * @return all persistences that match the parameters
     */
    public List<T> findBy(Map<String, String> criteria);
    
    /**
     * finds first persistence that match the parameters
     * @param criteria Map of attributes and values
     * @return first persistence that match the parameters
     */
    public T findOneBy(Map<String, String> criteria);
}