import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotCore extends TelegramLongPollingBot {
    private static final String START = "start";


    @Override
    public void onUpdateReceived(Update update) {
        // TODO writing logic...

        if (update.hasMessage() && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case START -> {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
                    sendMessage.setText("Hello World!");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "JavaDocsOracleBot";
    }

    @Override
    public String getBotToken() {
        //TODO Token
        return "";
    }
}
