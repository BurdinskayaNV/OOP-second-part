// Author: Бурдинская Наталья ВМК-22
package com.example.botik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Контроллер первого окна
public class BotikController {
    @FXML  // Форма главного окна
    public VBox Start;
    @FXML  // Текстовое поле для ввода имени пользователя
    private TextField TextFieldUserName;

    @FXML  // Обработчик события входа пользователя
    public void onHelloButtonClick(ActionEvent actionEvent) {
        try {
            new BotikWindow(TextFieldUserName.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(BotikController.class.getResource("botik-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
            Start.getScene().getWindow().hide();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}