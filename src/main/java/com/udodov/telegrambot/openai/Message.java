package com.udodov.telegrambot.openai;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Message(
        @JsonProperty("role") String role,
        @JsonProperty("content") String content) {
}
