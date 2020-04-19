package com.example.zzmdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.zzmdemo.mapper")
public class ZzmdemoApplication {

	public static void main(String[] args) {
		//解决netty冲突
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(ZzmdemoApplication.class, args);
	}

}
