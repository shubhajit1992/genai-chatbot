package com.shubhajit.genai.chatbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OllamaService {
    private final ChatClient chatClient;

    public String askModel(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}
