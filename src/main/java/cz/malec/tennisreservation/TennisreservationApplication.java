package cz.malec.tennisreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author Jiří Malec
 */
@SpringBootApplication
@ComponentScan(basePackages = { "cz.malec.tennisreservation.dao",
                                "cz.malec.tennisreservation.service",
                                "cz.malec.tennisreservation.controller",
                                "cz.malec.tennisreservation.config"})
public class TennisreservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisreservationApplication.class, args);
	}

}
