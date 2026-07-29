package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper") 
public class CopilotAlart {

	public static void main(String[] args) {
	    System.out.println("Current Directory = " + System.getProperty("user.dir"));
		SpringApplication.run(CopilotAlart.class, args);
	}

}
