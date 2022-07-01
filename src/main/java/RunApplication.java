import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class RunApplication {

    public static void main(String[] args) {

        // Initialyzing bot
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new BotCore());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}

