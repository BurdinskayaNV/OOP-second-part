// Author: Бурдинская Наталья ВМК-22
package com.example.bd_fish;

import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;
import java.text.NumberFormat;

public class MainController {

    /** Таблица для отображения данных */
    public TableView<Fish> MainTable;
    /** Поле для ввода ID */
    public TextField textField_id;
    /** Поле для ввода Наименование рыбы NameFish */
    public TextField textField_namefish;
    /** Поле для ввода Особенность - тип рыбы Feature */
    public TextField textField_feature;
    /** Поле для ввода Способ обработки Method */
    public TextField textField_method;
    /** Поле для ввода Размер рыбы Size */
    public TextField textField_size;
    /** Поле для ввода цена Price */
    public TextField textField_price;

    /** Кнопка для добавления рыбы */
    public Button ButtonAddFish;
    /** Кнопка для изменения данных о рыбе */
    public Button ButtonChangeFish;
    /** Кнопка для поиска рыбы */
    public Button ButtonSearchFish;

    /** Надпись для сообщений первого окна */
    @FXML
    private Label LabelMessage;
    /** Надпись для вывода подсказки */
    @FXML
    private Label HelpText;

    /** Колонка отображает ID */
    @FXML
    private final TableColumn<Fish,Integer> col_id  = new TableColumn<>("ID");;
    /** Колонка отображает Наименование рыбы */
    @FXML
    private final TableColumn<Fish,String> col_namefish = new TableColumn<>("Наименование рыбы");
    /** Колонка отображает Особенность - тип рыбы - белая, красная, лососевая ... */
    @FXML
    private final TableColumn<Fish,String> col_feature = new TableColumn<>("Тип рыбы");
    /** Колонка отображает Способ обработки - копчёная, вяленная, соленая ... */
    @FXML
    private final TableColumn<Fish,String> col_method = new TableColumn<>("Способ обработки ");
    /** Колонка отображает Размер рыбы - крупная мелкая ... */
    @FXML
    private final TableColumn<Fish,String> col_size = new TableColumn<>("Размер рыбы");
    /** Колонка отображает стоимость рыбы */
    @FXML
    private final TableColumn<Fish,Double> col_price = new TableColumn<>("Цена");

    /** Цвет для выделения ячейка красным */
    String redColor = "-fx-background-color: #f55236";
    /** Цвет для TextField по умолчанию */
    String StartColor = "-fx-background-color:";

    /** База данных в которой хранятся данные */
    public DBase dataBase;

    /** Добавление в таблицу колонок, связывание таблицы и базы для хранения данных */
    public void Create_Table(){

        // Связываем колонки и методы из Fish
        col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_namefish.setCellValueFactory(new PropertyValueFactory<>("NameFish"));
        col_feature.setCellValueFactory(new PropertyValueFactory<>("Feature"));
        col_method.setCellValueFactory(new PropertyValueFactory<>("Method"));
        col_size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        // Устанавливаем оптимальные значения ширины колонок
        col_id.setPrefWidth(100);
        col_namefish.setPrefWidth(150);
        col_feature.setPrefWidth(150);
        col_method.setPrefWidth(150);
        col_size.setPrefWidth(150);
        col_price.setPrefWidth(150);

        // Добавляем в таблицу колонки
        MainTable.getColumns().add(col_id);
        MainTable.getColumns().add(col_namefish);
        MainTable.getColumns().add(col_feature);
        MainTable.getColumns().add(col_method);
        MainTable.getColumns().add(col_size);
        MainTable.getColumns().add(col_price);

        // Создаём новую базу данных для хранения данных
        dataBase = new DBase();
        // Связываем таблицу и данные
        MainTable.setItems(dataBase.tableDBase);
    }

    /** Создание модального окна для добавления рыбы */
    public void CreateDataModalWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("win-view.fxml"));
        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load(), 750, 400);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:fish.png"));
        stage.setTitle("Введите данные ");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    /**  Вывод окна для добавления новых данных о рыбе */
    // @FXML
    public void onMenuItemAddClick() throws IOException {
        CreateDataModalWindow();
        ButtonAddFish.setVisible(true);
    }

    /** Вывод окна для изменения данных о рыбе по выделенной строке
     * если строка не выделена, то высветится окно с ошибкой */
    public void onMenuItemChangeClick(ActionEvent actionEvent) throws IOException {
        Fish a = MainTable.getSelectionModel().getSelectedItem();
        if (a == null){
            LabelMessage.setText("Выделите строку для изменения");
            return;
        }
        CreateDataModalWindow();
        textField_id.setText(a.getID().toString());
        textField_namefish.setText(a.getNameFish());
        textField_feature.setText(a.getFeature());
        textField_method.setText(a.getMethod());
        textField_size.setText(a.getSize());
        //textField_price.setText(a.getPrice().toString());
        String format = String.format("%1$,.2f", a.getPrice());
        textField_price.setText(format);

        ButtonChangeFish.setVisible(true);
    }

    /** Метод для удаления рыбы */
    public void onMenuItemDeleteClick(ActionEvent actionEvent) throws IOException {
        Fish a = MainTable.getSelectionModel().getSelectedItem();
        if (a == null){
            LabelMessage.setText("Выделите строку для удаления");
            return;
        }
        int b = MainTable.getSelectionModel().getFocusedIndex();
        dataBase.tableDBase.remove(b);
    }

   /** Метод для поиска данных */
    public void onMenuItemSearchClick(ActionEvent actionEvent) throws IOException {
        CreateDataModalWindow();
        ButtonSearchFish.setVisible(true);
        //textField_id.setVisible(false);
        //textField_feature.setVisible(false);
        //textField_price.setVisible(false);
    }
    /** Метод для сортировки таблицы по ID */
    public void onMenuItemIDSortClick(ActionEvent actionEvent) {
        dataBase.tableDBase.sort(Comparator.comparing(Fish::getID));
    }
    /** Метод для сортировки таблицы по Наименованию рыбы */
    public void onMenuItemNameFishSortClick(ActionEvent actionEvent) {
        dataBase.tableDBase.sort(Comparator.comparing(Fish::getNameFish));
    }
    /** Метод для сортировки таблицы по типу рыбы - Особенность */
    public void onMenuItemFeatureSortClick(ActionEvent actionEvent) {
        dataBase.tableDBase.sort(Comparator.comparing(Fish::getFeature));
    }
    /** Метод для сортировки таблицы по Способу обработка */
    public void onMenuItemMethodSortClick(ActionEvent actionEvent) {
        dataBase.tableDBase.sort(Comparator.comparing(Fish::getMethod));
    }
    /** Метод для сортировки таблицы по Размеру рыбы */
    public void onMenuItemSizeSortClick(ActionEvent actionEvent) {
        dataBase.tableDBase.sort(Comparator.comparing(Fish::getSize));
    }
    /** Метод для сортировки таблицы по Цене рыбы */
    public void onMenuItemPriceSortClick(ActionEvent actionEvent) {
        dataBase.tableDBase.sort(Comparator.comparing(Fish::getPrice));
    }

    /** Метод по нажатию на кнопку добавления рыбы в таблицу */
    public void onButtonAddFishClick(ActionEvent actionEvent) {
        /* Проверяем введённые данные
         * если данные неверны в HelpText выведется, что нужно ввести или исправить*/
        if(CheckData()){
            String id = textField_id.getText();
            Fish a = new Fish(Integer.parseInt(textField_id.getText()),textField_namefish.getText(),textField_feature.getText(),textField_method.getText(),textField_size.getText(),Double.parseDouble(textField_price.getText()));
            dataBase.addFish(a);
            ButtonChangeFish.setVisible(false);
            HelpText.getScene().getWindow().hide();
        };
    }

    /** Метода по нажатию на кнопку для изменения данных рыбе */
    public void onButtonChangeFishClick(ActionEvent actionEvent) {
        if(CheckData()){
            String id = textField_id.getText();
            Fish a = new Fish(Integer.parseInt(textField_id.getText()),textField_namefish.getText(),textField_feature.getText(),textField_method.getText(),textField_size.getText(),Double.parseDouble(textField_price.getText()));
            int b = MainTable.getSelectionModel().getFocusedIndex();
            dataBase.tableDBase.set(b,a);
            ButtonChangeFish.setVisible(false);
            HelpText.getScene().getWindow().hide();
        };
    }

    /** Поиск рыбы в базе, найденного выделяет
     * Если рыба не найдена появится окно с текстом об ошибке */
    public void onButtonSearchFishClick(ActionEvent actionEvent) throws IOException {
    //      if(CheckData()){
            for (int i = 1; i <= dataBase.tableDBase.size();i++){
                if (Objects.equals(dataBase.tableDBase.get(i).getID(),Integer.parseInt(textField_id.getText()))
                        || Objects.equals(dataBase.tableDBase.get(i).getNameFish(), textField_namefish.getText())
                        || Objects.equals(dataBase.tableDBase.get(i).getFeature(), textField_feature.getText())
                        || Objects.equals(dataBase.tableDBase.get(i).getMethod(), textField_method.getText())
                        || Objects.equals(dataBase.tableDBase.get(i).getSize(), textField_size.getText())
                        || Objects.equals(dataBase.tableDBase.get(i).getPrice(), Double.parseDouble(textField_price.getText()))
                ){
                    MainTable.getSelectionModel().select(i);
                    HelpText.getScene().getWindow().hide();
                    return;
                }
         //   }
            //HelpText.getScene().getWindow().hide();
            LabelMessage.setText("В каталоге такой рыбы не найдено!");
        }
    }

    /** Проверка введённых данных
     * Если данные введены неверно выведется сообщение, что нужно ввести*/
    public boolean CheckData(){
        String result = "Введите данные: ";
        boolean k = true;

        if (!dataBase.CheckID(textField_id.getText())){
            textField_id.setStyle(redColor);
            result+= "ID   ";
            k = false;
        }
        else { textField_id.setStyle(StartColor); }

        if (!dataBase.CheckNameFish(textField_namefish.getText())){
            textField_namefish.setStyle(redColor);
            result+= "Наименование рыбы  ";
            k = false;
        }
        else { textField_feature.setStyle(StartColor); }

        if (!dataBase.CheckFeature(textField_feature.getText())){
            textField_feature.setStyle(redColor);
            result+= "Особенность  ";
            k = false;
        }
        else { textField_feature.setStyle(StartColor); }

        if (!dataBase.CheckMethod(textField_method.getText())){
            textField_method.setStyle(redColor);
            result+= "Способ обработки  ";
            k = false;
        }
        else { textField_method.setStyle(StartColor); }

        if (!dataBase.CheckSize(textField_size.getText())){
            textField_size.setStyle(redColor);
            result+= "Размер рыбы  ";
            k = false;
        }
        else { textField_size.setStyle(StartColor); }

        if (!dataBase.CheckPrice(textField_price.getText())){
            textField_price.setStyle(redColor);
            result+= "Цена рыбы  ";
            k = false;
        }
        else { textField_price.setStyle(StartColor); }

        if (!k) { HelpText.setText(result); }
        return k;
    }

    /** Сохранение бд в файл  */
    public void onMenuItemSaveClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Текстовые документы","*.txt");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(LabelMessage.getScene().getWindow());//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            dataBase.SaveDataBaseInFile(file.getName());
        }
    }

    /** Открытие бд с файла */
    public void onMenuItemOpenClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Текстовые документы","*.txt");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(LabelMessage.getScene().getWindow());//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            dataBase.OpenDialogFromFile(file.getName());
        }
    }

    /** Выводит данные о программе */
    public void onMenuItemProgClick(ActionEvent actionEvent) {
        LabelMessage.setText("Эта программа хранит, данные каталога рыб магазина FRESH FISH !");
    }
    /** Выводит данные об авторе */
    public void onMenuItemAftoClick(ActionEvent actionEvent) {
        LabelMessage.setText("Бурдинская Наталья ВМК-22 ");
    }


}