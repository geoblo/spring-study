package com.icia.start01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 초기에 필요한 설정들이 다 들어가있는 어노테이션
public class Start01Application {

	// main 함수가 노출되어 있음
	public static void main(String[] args) {
		SpringApplication.run(Start01Application.class, args);
	}

}
