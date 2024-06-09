// Author: Бурдинская Наталья ВМК-22
package com.example.bd_fish;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

/** Класс база данных */
public class DBase {

    /** Регулярное выражение для проверки введенного ID */
    private static final String CheckNumber = "\\s?[0-9\\.]+\\s?";
    /** Регулярное выражение для проверки введенной стоимости Price */
    private static final String CheckDouble = "[0-9]+[\\.\\,]?[0-9]*";
    /** Регулярное выражение для проверки введенной строки */
    private static final String CheckString = "([А-ЯA-Zа-яa-z]+)";

    /** Список для хранения данных о рыбе */
    public ObservableList<Fish> tableDBase;

    DBase(){
        tableDBase = FXCollections.observableArrayList();
    }

    /** Добавление рыбы в таблицу */
    public void addFish(Fish a){
        tableDBase.add(a);
    }

    /** Проверка правильности ID */
    public boolean CheckID(String s){
        return s.matches(CheckNumber);
    }
    /** Проверка правильности Наименование рыбы */
    public boolean CheckNameFish(String s){
        return s.matches(CheckString);
    }
    /** Проверка правильности типа рыбы */
    public boolean CheckFeature(String s){
        return s.matches(CheckString);
    }
    /** Проверка правильности Способа обработки */
    public boolean CheckMethod(String s){
        return s.matches(CheckString);
    }
    /** Проверка правильности размера рыбы */
    public boolean CheckSize(String s){
        return s.matches(CheckString);
    }
    /** Проверка правильности цена рыбы */
    public boolean CheckPrice(String s){
        return s.matches(CheckDouble);
    }

    /** Сохранение базы данных в файл  */  ///***
    public void SaveDataBaseInFile(String fileName){

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName)))
        {
            for (int i = 0; i < tableDBase.size();i ++ ){
                dos.writeInt(tableDBase.get(i).getID());
                dos.writeUTF(tableDBase.get(i).getNameFish());
                dos.writeUTF(tableDBase.get(i).getFeature());
                dos.writeUTF(tableDBase.get(i).getMethod());
                dos.writeUTF(tableDBase.get(i).getSize());
                dos.writeDouble(tableDBase.get(i).getPrice());
            }
        }
        catch (IOException ex){ System.out.println(ex.getMessage()); }
    }

    /** Открытие базы данных из файла */  ///****
    public void OpenDialogFromFile(String fileName) {
        tableDBase.clear();
        int id;
        String namefish, feature, method, size;
        double price;

        try (DataInputStream dos = new DataInputStream(new FileInputStream(fileName))) {
            while (dos.available() != 0) {
                id = dos.readInt();
                namefish = dos.readUTF();
                feature = dos.readUTF();
                method = dos.readUTF();
                size = dos.readUTF();
                price = dos.readDouble();
                Fish a = new Fish(id, namefish, feature, method, size, price);
                tableDBase.add(a);
            }
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
    }
   public ObservableList<Fish> getList_studs() {
        return tableDBase;
    }
}