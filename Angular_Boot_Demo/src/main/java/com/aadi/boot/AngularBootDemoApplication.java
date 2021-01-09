package com.aadi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngularBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularBootDemoApplication.class, args);
	}

}

/*
 
 How to run this Demo SpringBoot+Angular App. This "Angular_Boot_Demo" back-end Project is attached to 
 "AngularBootDemoFrontEnd" project of front-end side. Start both of them in sync to fetch(consume) 
 url data of backEnd by FrondEnd, along with start MySQL db with database name as 'boot'.
 
 1. Here run this project as Spring boot.
 2. Go to browser & hit link : "http://localhost:8080/api/v1/employees" for back end.
 3. Run AngularBootDemoFrontEnd angular project in VScode, and open "http://localhost:4200/employees" in browser.
 4. Now enjoy CRUD(Create, Read, Update, Delete) operation on Employee entity data.
 
 Total technologies used :- Spring Boot + Spring Data JPA + MySQL + Angular + Bootstrap + HTML.
 
 */