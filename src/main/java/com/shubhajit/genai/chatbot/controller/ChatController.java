package com.shubhajit.genai.chatbot.controller;

import com.shubhajit.genai.chatbot.model.QueryRequest;
import com.shubhajit.genai.chatbot.service.OllamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final OllamaService ollamaService;

    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody QueryRequest request) {
        String result = ollamaService.askModel(request.getQuestion());
        return ResponseEntity.ok(result);
    }
}
