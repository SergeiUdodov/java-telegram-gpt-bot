package com.udodov.telegrambot.openai;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatCompletionObject(
        @JsonProperty("choices") List<Choice> choices) {
}
