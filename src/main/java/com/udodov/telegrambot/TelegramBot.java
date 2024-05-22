package com.udodov.telegrambot;

import com.udodov.telegrambot.openai.OpenAiClient;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {

    private final OpenAiClient openAiClient;

    public TelegramBot(DefaultBotOptions options, String botToken, OpenAiClient openAiClient) {
        super(options, botToken);
        this.openAiClient = openAiClient;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId().toString();

            var chatCompletionResponse = openAiClient.createChatCompletion(text);
            var textResponse = chatCompletionResponse.choices().get(0).message().content();

            SendMessage sendMessage = new SendMessage(chatId, textResponse);
            sendApiMethod(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "My-test-bot";
    }
}
