/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jiří Malec
 */
@RestController
@ControllerAdvice
public class ExceptionController {

    private final static Logger LOG = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * Catches every exception and displays information about it
     * @param request
     * @param exception to be handled
     * @return response map to by display
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, String> handleException(HttpServletRequest request, Exception exception) {
        LOG.warn("Request {} threw an exception {}", request, exception.getMessage());
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getClass().getSimpleName());
        response.put("message", exception.getMessage());
        return response;
    }

}
