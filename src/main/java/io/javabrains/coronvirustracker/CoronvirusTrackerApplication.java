package io.javabrains.coronvirustracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronvirusTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronvirusTrackerApplication.class, args);
	}

}
