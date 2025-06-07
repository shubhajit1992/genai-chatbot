# GenAI Chatbot

A lightweight, stateless RESTful chatbot backend built with Spring Boot, designed to interact with local LLMs via Ollama.

## Features

- Stateless REST API for chat-based LLM interaction
- Clean, testable Spring Boot structure
- Robust error handling and logging
- Easily configurable via `application.yml`

## Requirements

- Java 21+
- Gradle (or use the included `gradlew` wrapper)
- [Ollama](https://ollama.com/) running locally (default: `http://localhost:11434`)

## Getting Started

### 1. Clone the Repository

```sh
git clone https://github.com/shubhajit1992/genai-chatbot.git
cd genai-chatbot
```

### 2. Start Ollama

Ensure Ollama is running locally and the desired model (e.g., `mistral`) is available.

```sh
ollama run mistral
```

### 3. Configure the Application

Edit `src/main/resources/application.yml` if you want to change logging or other settings.

### 4. Build and Run

```sh
./gradlew bootRun
```

The API will be available at `http://localhost:8080/api/chat/ask`.

## API Usage

### POST `/api/chat/ask`

**Request Body:**
```json
{
  "question": "What is the capital of France?"
}
```

**Response:**
```json
"Paris"
```

## Project Structure

- `controller/ChatController.java` — REST API endpoint
- `service/OllamaService.java` — Service for calling Ollama LLM
- `model/QueryRequest.java` — DTO for chat requests
- `config/AppConfig.java` — Spring beans (e.g., `RestTemplate`)
- `application.yml` — Configuration

## Testing

Run all tests with:

```sh
./gradlew test
```

## Logging

Logs are written to `logs/genai-chatbot.log` (configurable in `application.yml`).

---

**Note:** This project does not use a database and is fully stateless. All configuration is handled via `application.yml` and environment variables.