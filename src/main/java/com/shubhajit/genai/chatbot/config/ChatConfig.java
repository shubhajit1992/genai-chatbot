package com.shubhajit.genai.chatbot.config;

import static org.springframework.ai.ollama.api.OllamaOptions.DEFAULT_MODEL;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient chatClient() {
        OllamaApi ollamaApi = new OllamaApi();

        OllamaOptions options = OllamaOptions.builder()
                .withModel(DEFAULT_MODEL)  // 👈 required
                .build();

        OllamaChatModel model = new OllamaChatModel(ollamaApi, options);

        return ChatClient.builder(model).build();
    }
}
