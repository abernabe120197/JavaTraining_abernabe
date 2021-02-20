package com.bootcamp.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		String test = new BCryptPasswordEncoder().encode("admin");
		System.out.print(new BCryptPasswordEncoder().encode("admin"));
	}

}
