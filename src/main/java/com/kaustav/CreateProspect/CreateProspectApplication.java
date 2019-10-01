package com.kaustav.CreateProspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"controller","pojo"})
@EnableMongoRepositories("dbrepository")
public class CreateProspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateProspectApplication.class, args);
	}

}
