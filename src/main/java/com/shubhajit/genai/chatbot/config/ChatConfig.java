package com.shubhajit.genai.chatbot.config;

import static org.springframework.ai.ollama.api.OllamaModel.MISTRAL;

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
        OllamaApi ollamaApi = OllamaApi.builder().build();

        OllamaOptions ollamaOptions = OllamaOptions.builder()
                .model(MISTRAL.id())  // 👈 required
                .build();

        OllamaChatModel model = OllamaChatModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(ollamaOptions)
                .build();

        return ChatClient.builder(model).build();
    }
}
