// Author: Бурдинская Наталья ВМК-22
package com.example.botik;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import static com.example.botik.Bot.*;

// класс чата второго окна
public class BotikWindow {

    // Конструктор окна с чатом
    public BotikWindow(String userName) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BotikWindow.class.getResource("chatik-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("file:chat.png"));
        stage.setTitle("Чат-бот с " + userName);
        stage.setScene(scene);
        stage.show();

        // Получаем контролер окна
        BotikWindowController controllerEditBook = fxmlLoader.getController();

        // Создаем бота для окна
        Bot MainBot = new Bot(userName);

        // Открываем диалог
        MainBot.OpenDialogFromFile(controllerEditBook);

        //Связываем бота и контроллер окна
        controllerEditBook.MainBot = MainBot;

        // Для события после закрытия окна
        stage.setOnCloseRequest(controllerEditBook.getCloseEventHandler());
    }
}