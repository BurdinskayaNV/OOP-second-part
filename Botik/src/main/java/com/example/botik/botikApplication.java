// Author: Бурдинская Наталья ВМК-22
package com.example.botik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

// главный класс первого окна
public class botikApplication extends Application {

    @Override  // Конструктор первого окна
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(botikApplication.class.getResource("botik-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 820);
        stage.getIcons().add(new Image("file:chat.png"));
        stage.setTitle("Коннор");
        //boolean add = stage.getIcons().add(new Image("/chat.png"));
        stage.setScene(scene);
        stage.show();
    }
    // Запуск программы
    public static void main(String[] args) {
        launch();
    }
}