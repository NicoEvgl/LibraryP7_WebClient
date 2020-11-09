package com.nicoe.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.nicoe.library")
public class LibraryWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryWebClientApplication.class, args);
	}

}
