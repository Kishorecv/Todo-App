package com.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {


	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		for(int i=1;i<=10;i++){
			String encodedpwd = bCryptPasswordEncoder.encode("password@123!");
			System.out.println(encodedpwd);
		}
		
		

	}

}
