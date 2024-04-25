// Author: Бурдинская Наталья ВМК-22
package com.example.rectangleclassfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import RectangleClass.Rectangle;
import javafx.stage.Stage;

// Класс с обработчиками событий главного окна
public class MainController {
    //
    // Создаём ссылку на обьект, с которым будем работать
    //
    Rectangle MainRectangle = new Rectangle();

    // Главное окно программы
    public VBox MainWindow;

    /** Элемент для считывания координаты X вершины A*/
    public TextField Text_AX;

    /** Элемент для считывания координаты X вершины B*/
    public TextField Text_BX;

    /** Элемент для считывания координаты X вершины C*/
    public TextField Text_CX;

    /** Элемент для считывания координаты Y вершины A*/
    public TextField Text_AY;

    /** Элемент для считывания координаты Y вершины B*/
    public TextField Text_BY;

    /** Элемент для считывания координаты Y вершины C*/
    public TextField Text_CY;

    /** Элемент для координаты X вершины D*/
    public TextField Text_DX;

    /** Элемент для координаты Y вершины D*/
    public TextField Text_DY;

    /** Элемент для типа прямоугольника*/
    public TextField Text_figure;

    /** Элемент для длины стороны А*/
    public TextField Text_lengthA;

    /** Элемент для длины стороны В*/
    public TextField Text_lengthB;

    /** Элемент для  периметра прямоугольника*/
    public TextField Text_Per;

    /** Элемент для площади прямоугольника*/
    public TextField Text_Sq;

    /** Надпись для основного окна */
    public Label Label_Main;

    /** Надпись для задания координат*/
    public Label Label_Coor;

    /** Надпись A */
    public Label Label_A;

    /** Надпись B */
    public Label Label_B;

    /** Надпись C */
    public Label Label_C;

    /** Надпись X */
    public Label Label_X;

    /** Надпись Y */
    public Label Label_Y;

    /** Надпись D */
    public Label Label_D;

    /** Надпись для вывода площади прямоугольника*/
    public Label Label_Sq;

    /** Надпись для вывода длины стороны A*/
    public Label Label_lengthA;

    /** Надпись для вывода длины стороны B*/
    public Label Label_lengthB;

    /** Надпись для вывода периметра прямоугольника*/
    public Label Label_Per;

    /** Кнопка для определения фигуры по 3 координатам точек*/
    public Button Button_Figure;

    /** Кнопка для нахождения координат 4 точки*/
    public Button Button_FindD;

    /** Кнопка для рассчёта прямоугольника*/
    public Button Button_Result;

    /** Кнопка для задания координат прямоугольника*/
    public Button Button_Create;

    /** Кнопка для выхода*/
    @FXML
    public Button closeButton;

    // Округляет число до целого, если до целого меньше 0.00001
    private double RoundNumberDouble(double num){
        double Rnum = Math.round(num);
        if (Math.abs(num - Rnum) < 0.00001){
            return Rnum;
        }
        else{
            return num;
        }
    }

    //  Проверка можно ли преобразовать string в double
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /** Обработчик события для кнопки Button_Create
     * задает координаты точек*/
    public void onButton_CreateClick()
    {
        Text_AX.setText("0.0");
        MainRectangle.set_x1(Double.parseDouble(Text_AX.getText()));
        Text_AY.setText("0.0");
        MainRectangle.set_y1(Double.parseDouble(Text_AY.getText()));
        Text_BX.setText("4.0");
        MainRectangle.set_x2(Double.parseDouble(Text_BX.getText()));
        Text_BY.setText("0.0");
        MainRectangle.set_y2(Double.parseDouble(Text_BY.getText()));
        Text_CX.setText("0.0");
        MainRectangle.set_x3(Double.parseDouble(Text_CX.getText()));
        Text_CY.setText("6.0");
        MainRectangle.set_y3(Double.parseDouble(Text_CY.getText()));
    }

    /** Обработчик события для кнопки Button_Figure
     * определяет, является ли фигура прямоугольником */
    public void onButton_FigureClick()
    {
        String AX = Text_AX.getText();
        MainRectangle.set_x1(Double.parseDouble(AX));
        String AY = Text_AY.getText();
        MainRectangle.set_y1(Double.parseDouble(AY));
        String BX = Text_BX.getText();
        MainRectangle.set_x2(Double.parseDouble(BX));
        String BY = Text_BY.getText();
        MainRectangle.set_y2(Double.parseDouble(BY));
        String CX = Text_CX.getText();
        MainRectangle.set_x3(Double.parseDouble(CX));
        String CY = Text_CY.getText();
        MainRectangle.set_y3(Double.parseDouble(CY));

        double al = MainRectangle.AngleRectangle();
        if (al == 0)
        {
            Text_figure.setText("Это прямоугольник");
            // Text_figure.setText("Косинус равен " + String.format("%.2f",RoundNumberDouble(al)));
            Button_FindD.setDisable(false);
            Label_D.setDisable(false);
            Text_DX.setDisable(false);
            Text_DX.setText("0");
            Text_DY.setDisable(false);
            Text_DY.setText("0");
            Button_Result.setDisable(false);
            Label_lengthA.setDisable(false);
            Label_lengthB.setDisable(false);
            Label_Per.setDisable(false);
            Label_Sq.setDisable(false);
            Text_lengthA.setDisable(false);
            Text_lengthA.setText("0");
            Text_lengthB.setDisable(false);
            Text_lengthB.setText("0");
            Text_Per.setDisable(false);
            Text_Per.setText("0");
            Text_Sq.setDisable(false);
            Text_Sq.setText("0");
        }
        else
        {
            Text_figure.setText("Это не прямоугольник");
            Button_FindD.setDisable(true);
            Label_D.setDisable(true);
            Text_DX.setDisable(true);
            Text_DY.setDisable(true);
            Button_Result.setDisable(true);
            Label_lengthA.setDisable(true);
            Label_lengthB.setDisable(true);
            Label_Per.setDisable(true);
            Label_Sq.setDisable(true);
            Text_lengthA.setDisable(true);
            Text_lengthB.setDisable(true);
            Text_Per.setDisable(true);
            Text_Sq.setDisable(true);
        }
    }

    /** Обработчик события для кнопки Button_Figure
     * определяет, является ли фигура прямоугольником */
    public void onButton_FindDClick() {

        Text_DX.setText(String.format("%.2f",RoundNumberDouble(MainRectangle.СoordinateX4())));
        Text_DY.setText(String.format("%.2f",RoundNumberDouble(MainRectangle.СoordinateY4())));
    }
    /** 0Обработчик события для кнопки closeButton */
    /** Кнопка для выхода*/
    @FXML
    public void oncloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /** Обработчик события для кнопки Button_Result
     * РАссчитывает треугольник и выводит необходимые данные*/
    public void onButtonResultClick(ActionEvent actionEvent) {
        // Проверка введённых данных на корректность
        if (isDouble(Text_AX.getText())) {MainRectangle.set_x1(Double.parseDouble(Text_AX.getText())); }
        else{Text_AX.setText(Double.toString(MainRectangle.get_x1()));}

        if (isDouble(Text_AY.getText())) {MainRectangle.set_y1(Double.parseDouble(Text_AY.getText())); }
        else{Text_AY.setText(Double.toString(MainRectangle.get_y1()));}

        if (isDouble(Text_BX.getText())) {MainRectangle.set_x2(Double.parseDouble(Text_BX.getText())); }
        else{Text_BX.setText(Double.toString(MainRectangle.get_x2()));}

        if (isDouble(Text_BY.getText())) {MainRectangle.set_y2(Double.parseDouble(Text_BY.getText())); }
        else{Text_BY.setText(Double.toString(MainRectangle.get_y2()));}

        if (isDouble(Text_CX.getText())) {MainRectangle.set_x3(Double.parseDouble(Text_CX.getText())); }
        else{Text_CX.setText(Double.toString(MainRectangle.get_x3()));}

        if (isDouble(Text_CY.getText())) {MainRectangle.set_y3(Double.parseDouble(Text_CY.getText())); }
        else{Text_CY.setText(Double.toString(MainRectangle.get_y3()));}


        // Устанавливаем новые даннеы в треугольник
        //MainRectangle.Set_AllCoordinate(ax,ay,bx,by,cx,cy);
        // Выводим снова данные, если координаты треугольника не поменялись
        Text_AX.setText(Double.toString(MainRectangle.get_x1()));
        Text_BX.setText(Double.toString(MainRectangle.get_x2()));
        Text_CX.setText(Double.toString(MainRectangle.get_x3()));
        Text_AY.setText(Double.toString(MainRectangle.get_y1()));
        Text_BY.setText(Double.toString(MainRectangle.get_y2()));
        Text_CY.setText(Double.toString(MainRectangle.get_y3()));


        // Выводим все необходимые данные в соответствующие поля
        Text_lengthA.setText(String.format("%.2f",RoundNumberDouble(MainRectangle.SideRectangleA())));
        Text_lengthB.setText(String.format("%.2f",RoundNumberDouble(MainRectangle.SideRectangleB())));

        Text_Per.setText(String.format("%.2f",RoundNumberDouble(MainRectangle.PerimeterXY())));

        Text_Sq.setText(String.format("%.2f",RoundNumberDouble(MainRectangle.SquareXY())));

    }
}