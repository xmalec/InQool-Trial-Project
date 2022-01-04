/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.exception;

/**
 *
 * @author Jiří Malec
 */
public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String message) {
        super(message);
    }
    
}
