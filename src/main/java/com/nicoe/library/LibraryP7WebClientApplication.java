package com.nicoe.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.nicoe.library")
public class LibraryP7WebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryP7WebClientApplication.class, args);
	}

}
