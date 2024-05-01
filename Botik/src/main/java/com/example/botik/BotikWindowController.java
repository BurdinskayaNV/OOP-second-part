package com.example.botik;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import java.io.*;

import static com.example.botik.Bot.*;

// Класс контроллер для окна с чатом
public class BotikWindowController {

    // Текстовое поле ввода сообщения
    public TextField TextFieldMessage;

    // Текстовое поле отображения всего чата
    public TextArea TextAreaMessages;

    // Бот данного окна
    public Bot MainBot;

    // событие на кнопку чата
    public void onButtonSendMessage(ActionEvent actionEvent) throws IOException {
        AppendMessageInTextArea(MainBot.addMessage(TextFieldMessage.getText()));
        TextFieldMessage.setText("");
    }

    // Выводит собщение в поле с чатом
    public void AppendMessageInTextArea(String message){
        TextAreaMessages.appendText(message + "\n");
    }

    private final javafx.event.EventHandler<WindowEvent> closeEventHandler = new javafx.event.EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            MainBot.SaveDialogInFile();
        }
    };

    // действия после закрытия окна
    public javafx.event.EventHandler<WindowEvent> getCloseEventHandler(){ return closeEventHandler; }
}
