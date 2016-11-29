package com.glenware.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SpringBootApplication
public class ParkrunpbApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParkrunpbApplication.class, args);
		
		String password = "BCryptPasswordEncoder";
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = bCryptPasswordEncoder.encode(password);
		System.out.println("BCryptPasswordEncoder mrf " + hashedPassword);
		
		String password1 = "StandardPasswordEncoder";
		StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
		String hashedPassword1 = standardPasswordEncoder.encode(password1);
		System.out.println("StandardPasswordEncoder mrf " + hashedPassword1);
		
		String password2 = "NoOpPasswordEncoder";
		PasswordEncoder passwordEncoder2 = NoOpPasswordEncoder.getInstance();
		String hashedPassword2 = passwordEncoder2.encode(password2);
		System.out.println("NoOpPasswordEncoder mrf " + hashedPassword2);
		
    }
}
