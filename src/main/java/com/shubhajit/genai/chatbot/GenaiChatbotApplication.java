package com.shubhajit.genai.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenaiChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenaiChatbotApplication.class, args);
		System.out.println("GenAI Chatbot Application Started Successfully!");
	}

}
