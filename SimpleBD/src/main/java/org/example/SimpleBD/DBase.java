package org.example.SimpleBD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

/** Класс база данных */
public class DBase {

    /** Список для хранения данных о рыбе */
    public ObservableList<Fish> tableDBase;

    DBase(){
        tableDBase = FXCollections.observableArrayList();
    }

    /** Добавление рыбы в таблицу */
    public void addFish(Fish a){
         tableDBase.add(a);
     }

    public void Add(Integer id, String nameFish, String feature, String method, String weight, String size, Double price){
        Fish s = new Fish(id, nameFish, feature, method, weight, size, price);
        tableDBase.add(s);
    }

    public void Del(int number){
        if (number>=0&&number<tableDBase.size())
            tableDBase.remove(number);
        else throw new IllegalArgumentException("Нет строки с таким номером");
        ///else throw new IllegalArgumentException("There is no row with this number");
    }

    public void ChangeID(Integer number, Integer new_value){
        Fish s = tableDBase.get(number);
        s.setID(new_value);
        tableDBase.set(number, s);
    }

    public void ChangeNameFish(Integer number, String new_value){
        Fish s = tableDBase.get(number);
        s.setNameFish(new_value);
        tableDBase.set(number, s);
    }

    public void ChangeFeature(Integer number, String new_value){
        Fish s = tableDBase.get(number);
        s.setFeature(new_value);
        tableDBase.set(number, s);
    }

    public void ChangeMethod(Integer number, String new_value){
        Fish s = tableDBase.get(number);
        s.setMethod(new_value);
        tableDBase.set(number, s);
    }

    public void ChangeWeight(Integer number, String new_value){
        Fish s = tableDBase.get(number);
        s.setWeight(new_value);
        tableDBase.set(number, s);
    }

    public void ChangeSize(Integer number, String new_value){
        Fish s = tableDBase.get(number);
        s.setSize(new_value);
        tableDBase.set(number, s);
    }

    public void ChangePrice(Integer number, Double new_value){
        Fish s = tableDBase.get(number);
        s.setPrice(new_value);
        tableDBase.set(number, s);
    }

    public void Change(Integer num_row, Integer num_col, String new_value){
        if (num_row >= 0 && num_row < tableDBase.size()) {
            if (num_col == 0) ChangeID(num_row, Integer.parseInt(new_value));
            else if (num_col == 1) ChangeNameFish(num_row, new_value);
            else if (num_col == 2) ChangeFeature(num_row, new_value);
            else if (num_col == 3) ChangeMethod(num_row, new_value);
            else if (num_col == 4) ChangeWeight(num_row, new_value);
            else if (num_col == 5) ChangeSize(num_row, new_value);
            else if (num_col == 6) ChangePrice(num_row, Double.parseDouble(new_value));
            else throw new IllegalArgumentException("Столбца с таким номером нет");
            /// else throw new IllegalArgumentException("There is no column with this number");
        } else throw new IllegalArgumentException("Нет строки с таким номером");
        /// else throw new IllegalArgumentException("There is no row with this number");
    }

    /** Проверка правильности ID */
    public boolean CheckID(String s){
        return Objects.equals(s, "");
    }
    /** Проверка правильности Наименования рыбы */
    public boolean CheckNameFish(String s){
         return Objects.equals(s, "");
     }
    /** Проверка правильности Осовенности - типа рыбы - белая, красная, лососевая ... */
    public boolean CheckFeature(String s){
        return Objects.equals(s, "");
    }
    /** Проверка правильности Способа обработки - копчёная, вяленная, соленая ... */
    public boolean CheckMethod(String s){
        return Objects.equals(s, "");
    }
    /** Проверка правильности Веса рыбы */
    public boolean CheckWeight(String s){
        return Objects.equals(s, "");
    }
    /** Проверка правильности Размера рыбы - крупная мелкая ... */
    public boolean CheckSize(String s){
        return Objects.equals(s, "");
    }
    /** Проверка правильности стоимости рыбы */
    public boolean CheckPrice(String s){
        return Objects.equals(s, "");
    }

    public void load(){
        // todo: загрузка из файла
    }

    public void save(){
        // todo: сохранение в файл
    }
    public ObservableList<Fish> getList_studs() {
        return tableDBase;
    }
}
