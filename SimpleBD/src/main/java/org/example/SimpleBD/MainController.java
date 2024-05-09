package org.example.SimpleBD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import javax.lang.model.type.NullType;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** Класс-контроллер для главного окна */
public class MainController implements Initializable {

    @FXML
    /** будет показывать данные из ObservableList; */
    /** Таблица для отображения данных */
    private TableView<Fish> MainTable;
    @FXML
    /** Поле для ввода id */
    private TextField textField_id;
    @FXML
    /** Поле для ввода Наименование рыбы */
    private TextField textField_name;

    ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
    ComboBox<String> langsComboBox = new ComboBox<String>(langs);
    ///  langsComboBox.setValue("Java"); // устанавливаем выбранный элемент по умолчанию
    private ComboBox ComboBox_Name;

    @FXML
    /** Поле для ввода Особенность - тип рыбы - белая, красная, лососевая ... */
    private TextField textField_feature;
    @FXML
    /** Поле для ввода Способ обработки - копчёная, вяленная, соленая ... */
    private TextField textField_method;
    @FXML
    /** Поле для ввода Вес рыбы */
    private TextField textField_weight;
    @FXML
    /** Поле для ввода Размер рыбы - крупная мелкая ... */
    private TextField textField_size;
    @FXML
    /** Поле для ввода стоимость рыбы */
    private TextField textField_price;
    @FXML
    /** Поле для выбора индекса */
    private TextField textField_id1;
    @FXML
    /** Поле для выбора индекса */
    private TextField textField_name1;
    @FXML
    /** Поле для выбора индекса */
    private TextField textField_name2;
    @FXML
    private Label messages;

    /** Колонка отображает ID */
    private final TableColumn<Fish,String> col_id = new TableColumn<>("ID");
    /** Колонка отображает Наименование рыбы */
    private final TableColumn<Fish,String> col_name = new TableColumn<>("Наименование");
    /** Колонка отображает Особенность - тип рыбы - беллая, красная, лососевая ... */
    private final TableColumn<Fish,String> col_feature = new TableColumn<>("Особенности");
    /** Колонка отображает Способ обработки - копчёная, вяленная, соленая ... */
    private final TableColumn<Fish,String> col_method = new TableColumn<>("Способ обработки");
    /** Колонка отображает Вес рыбы */
    private final TableColumn<Fish,String> col_weight = new TableColumn<>("Вес");
    /** Колонка отображает Размер рыбы - крупная мелкая ... */
    private final TableColumn<Fish,String> col_size = new TableColumn<>("Размер");
    /** Колонка отображает стоимость рыбы */
    private final TableColumn<Fish,Double> col_price = new TableColumn<>("Цена");
    /** Цвет для выделения ячейка красным */
    String redColor = "-fx-background-color: #f55236";
    /** Цвет для TextField по умолчанию */
    String StartColor = "-fx-background-color:";
    /** База данных в которой хранятся данные */
    DBase dataBase;

    /** содержит модель данных (ObservableList) */
    private DBase db = new DBase();

    /** Вызывается после того как форма создана. Можно обращаться к её содержимому */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        // Связываем колонки и методы из Fish
        col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("NameFish"));
        col_feature.setCellValueFactory(new PropertyValueFactory<>("Feature"));
        col_method.setCellValueFactory(new PropertyValueFactory<>("Method"));
        col_weight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        col_size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        // Добавляем в таблицу колонки
        MainTable.getColumns().add(col_id);
        MainTable.getColumns().add(col_name);
        MainTable.getColumns().add(col_feature);
        MainTable.getColumns().add(col_method);
        MainTable.getColumns().add(col_weight);
        MainTable.getColumns().add(col_size);
        MainTable.getColumns().add(col_price);

        // Связываем таблицу и данные
        MainTable.setItems(db.getList_studs());
    }

    @FXML
    protected void onAddButtonClick() {
        String s1 = textField_id.getText();
        String s2 = textField_name.getText();
        String s3 = textField_feature.getText();
        String s4 = textField_method.getText();
        String s5 = textField_weight.getText();
        String s6 = textField_size.getText();
        String s7 = textField_price.getText();
        try {
            if (Integer.parseInt(s1) < 0|| s1.isEmpty()) throw new IllegalArgumentException("Должно быть больше или равно нулю");
            else if (s2.isEmpty()) throw new IllegalArgumentException("Поле Наименование не должно быть пустым");
            else if (s3.isEmpty()) throw new IllegalArgumentException("Поле Особенности не должно быть пустым");
            else if (s4.isEmpty()) throw new IllegalArgumentException("Поле Способ обработки не должно быть пустым");
            else {
                db.Add(Integer.parseInt(s1), s2, s3, s4, s5, s6, Double.parseDouble(s7));
                messages.setText("Запись добавлена !!!");
                textField_id.setText("");
                textField_name.setText("");
                textField_feature.setText("");
                textField_method.setText("");
                textField_weight.setText("");
                textField_size.setText("");
                textField_price.setText("");
            }
        }
        catch(IllegalArgumentException e) {
            messages.setText(e.getLocalizedMessage());
        }
    }

    /** Проверка введённых данных */
    public boolean CheckNameFish(){
        String result = "Введите данные: ";
        boolean k = true;

        if (db.CheckID(textField_id.getText())){
            textField_id.setStyle(redColor);
            result+= "ID ";
            k = false;
        }
        if (dataBase.CheckNameFish(textField_name.getText())){
            textField_name.setStyle(redColor);
            result+= "Наименование ";
            k = false;
        }
        else{ textField_name.setStyle(StartColor); }

        if (dataBase.CheckFeature(textField_feature.getText())){
            textField_feature.setStyle(redColor);
            result+= "Особенности ";
            k = false;
        }
        else{ textField_feature.setStyle(StartColor); }

        if (dataBase.CheckMethod(textField_method.getText())){
            textField_method.setStyle(redColor);
            result+= "Способ обработки ";
            k = false;
        }
        else{ textField_method.setStyle(StartColor); }

        if (dataBase.CheckWeight(textField_weight.getText())){
            textField_weight.setStyle(redColor);
            result+= "Вес ";
            k = false;
        }
        else{ textField_weight.setStyle(StartColor); }

        if (dataBase.CheckSize(textField_size.getText())){
            textField_size.setStyle(redColor);
            result+= "Размер ";
            k = false;
        }
        else{ textField_size.setStyle(StartColor); }

        if (dataBase.CheckPrice(textField_price.getText())){
            textField_price.setStyle(redColor);
            result+= "Цена ";
            k = false;
        }
        else{ textField_price.setStyle(StartColor); }

        if (!k){ messages.setText(result); }
        return k;
    }

    public void onDeleteButtonClick(ActionEvent actionEvent) {
        try {
            db.Del(Integer.parseInt(textField_id1.getText())-1);
            messages.setText("Запись удалена !!!");
        }
        catch (IllegalArgumentException e){ messages.setText("В таблице нет такой строки");}
    }

    public void onChangeButtonClick(ActionEvent actionEvent) {
       try {
            db.Change(Integer.parseInt(textField_id1.getText())-1, Integer.parseInt(textField_name1.getText())-1, textField_name2.getText());
            messages.setText("Запись изменена !!!");
        }
        catch (IllegalArgumentException e){
            messages.setText(e.getLocalizedMessage());}
    }
}