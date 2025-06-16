package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello, World!";
	}

	@GetMapping("/about")
	public String about() {
		return "This is a simple Spring Boot application.";
	}

	@PostMapping("/sign-in")
	public String signIn(@RequestBody LoginRequest loginRequest) {
		// In a real application, you would handle user authentication here
		return "User signed in with email: " + loginRequest.getEmail();
	}

	// Class to represent login request data
	// @Schema(description = "Login request payload", example = "{\"email\": \"user@example.com\", \"password\": \"string\"}")
	static class LoginRequest {
		@Schema(description = "User's email address", example = "user@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
		private String email;
		@Schema(description = "User's password", example = "P@$$wOrd", requiredMode = Schema.RequiredMode.REQUIRED)
		private String password;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
