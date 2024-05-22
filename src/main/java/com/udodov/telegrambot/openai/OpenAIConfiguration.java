package com.udodov.telegrambot.openai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfiguration {

    @Bean
    public OpenAiClient openAiClient(@Value("${openai.token}") String botToken, RestTemplateBuilder restTemplateBuilder) {
        return new OpenAiClient(botToken, restTemplateBuilder.build());
    }
}
