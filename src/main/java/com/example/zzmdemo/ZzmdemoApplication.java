package com.example.zzmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:application-shiro.xml"})
public class ZzmdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZzmdemoApplication.class, args);
	}

}
