package com.Briantpt30.TaskProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		TaskProjectApplication.class
})
public class TaskProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskProjectApplication.class, args);
	}

}

