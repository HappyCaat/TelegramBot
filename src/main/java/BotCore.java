import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class BotCore extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // TODO writing logic...

        Message message = update.getMessage();

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();

            //initKeyboard
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setResizeKeyboard(true);
            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            KeyboardRow keyboardRow1 = new KeyboardRow();
            KeyboardRow keyboardRow2 = new KeyboardRow();
            KeyboardButton keyboardButton1 = new KeyboardButton();
            KeyboardButton keyboardButton2 = new KeyboardButton();
            KeyboardButton keyboardButton3 = new KeyboardButton();
            keyboardButton1.setText("Что умеет этот бот");
            keyboardButton2.setText("Справка Java");
            keyboardButton3.setText("Поиск");
            keyboardRow1.add(keyboardButton1);
            keyboardRow2.add(keyboardButton2);
            keyboardRow1.add(keyboardButton3);
            keyboardRowList.add(keyboardRow1);
            keyboardRowList.add(keyboardRow2);
            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);


            switch (message.getText()) {
                case Constants.START -> {

                    sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
                    sendMessage.setText("Hello World!");

                    try {
                        execute(sendMessage);

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case Constants.TASK -> {

                    sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
                    sendMessage.setText("Этот бот собрал информацию по основным разделам документации Java. И с радостью готов ею поделиться с вами");

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
