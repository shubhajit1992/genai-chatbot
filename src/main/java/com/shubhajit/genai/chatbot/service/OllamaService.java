package com.shubhajit.genai.chatbot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OllamaService {
    private final RestTemplate restTemplate;

    public String askModel(String question) {
        String ollamaUrl = "http://localhost:11434/api/generate";

        Map<String, Object> request = new HashMap<>();
        request.put("model", "mistral");
        request.put("prompt", question);
        request.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(ollamaUrl, entity, Map.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Object result = response.getBody().get("response");
                return result != null ? result.toString() : "";
            } else {
                log.error("Ollama API error: {}", response.getStatusCode());
                return "Error: Ollama API returned " + response.getStatusCode();
            }
        } catch (RestClientException e) {
            log.error("Ollama API call failed", e);
            return "Error: Unable to connect to Ollama API";
        }
    }
}
