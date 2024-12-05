/*
 * Copyright (c) 2024 Broadcom, Inc. or its affiliates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.hellospringai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner onStartup(ChatClient.Builder chatClientBuilder,
                                ChatModel chatModel,
                                @Value("${app.topic:programming}") String defaultTopic) {
        return args -> {
            System.out.print("🎤 Enter your topic: ");
            var scanner = new Scanner(System.in);
            var topicArg = scanner.nextLine().trim();
            final var topic = topicArg.isEmpty() ? defaultTopic : topicArg;

            System.out.println("🤔 Generating joke about \"" + topic + "\"...");
            System.out.println("👀 Using chat model: " + chatModel);
            System.out.println("---");

            var chatClient = chatClientBuilder.build();
            var joke = chatClient.prompt()
                    .user(p -> p.text("""
                                    Tell me a joke about {topic}.
                                    Don't add anything else to your answer, only the joke itself.
                                    """
                            ).param("topic", topic)
                    ).system("""
                            You're a comedian.
                            Don't tell offensive jokes.
                            """)
                    .call().content();

            System.out.println("🤖 " + joke);
        };
    }
}
