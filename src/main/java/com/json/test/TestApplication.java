package com.json.test;

import com.json.test.service.JsonbService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	 @Bean
	 CommandLineRunner run(JsonbService jsonService) {
        return args -> {
//			Working
//            jsonService.saveJsonB();

//            System.out.println(jsonService.extractFieldFromJsonB(1L,"nome"));
//			jsonService.sendCSV2();
        };


    }
}
