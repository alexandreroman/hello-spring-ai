# Hello Spring AI!

This application demonstrates a simple way to interact with a large language model (LLM)
using [Spring AI](https://spring.io/projects/spring-ai)'s `ChatClient` API.

Spring AI provides a familiar Spring-based approach to integrating AI functionalities into your applications.

## What it does

This program fetches a joke about a specified topic from an LLM.

Here's how it works:

1.  **Configuration:** The app retrieves the chosen topic (defaults to "programming") from application properties.
2.  **ChatClient Setup:** It builds a `ChatClient` instance using the builder pattern.
3.  **Prompt Construction:** It crafts a prompt with two messages:
    *   **User Message:** Instructs the model to tell a joke about the chosen topic and emphasizes keeping the response concise (joke only).
    *   **System Message:** Acts as a guardrail to prevent potentially offensive jokes.
4.  **Joke Generation:** It sends the prompt to the LLM and retrieves the generated joke as a `String`.
5.  **Output:** It displays the chosen topic, followed by the generated joke.

## Benefits of using Spring AI

*   **Simplified AI Integration:** Spring AI offers a fluent and familiar API for interacting with LLMs, similar to using Spring's `WebClient` or `RestClient`.
*   **POJO-based approach:** Spring AI leverages Plain Old Java Objects (POJOs) as the building blocks, making it easy to understand and integrate into existing Spring applications.
*   **Model Portability:** The `ChatClient` API is designed to work with various LLMs, providing flexibility in choosing the most suitable model for your needs.

## Running the application

1. Ensure you have JDK installed.
2. Download/clone this project.
3. Add your desired LLM configuration to your application.properties file (refer to Spring AI documentation for specific configuration).
4. Start [Ollama](https://ollama.com) on your workstation: `ollama serve`
5. Download the LLM: `ollama pull gemma:2b`
6. Run the application using: `./mvnw spring-boot:run`

This will print the chosen topic and the generated joke to the console.

## Next steps

This is a basic example showcasing Spring AI's `ChatClient` API.

You can extend this application by:

*   Switch to a different AI provider by using another Spring AI starter (see [pom.xml](pom.xml) for details)
*   Implementing a user interface for entering the desired topic and displaying the joke.
*   Exploring other functionalities provided by Spring AI, such as advisors for specific use cases and conversation memory management.

## Contributing

Contributions are always welcome!

Feel free to open issues & send PR.

## License

Copyright &copy; 2025 [Broadcom, Inc. or its affiliates](https://vmware.com).

This project is licensed under the [Apache Software License version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
