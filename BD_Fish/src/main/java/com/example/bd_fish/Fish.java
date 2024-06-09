// Author: Бурдинская Наталья ВМК-22
package com.example.bd_fish;

public class Fish {
    /** ID */
    private Integer ID;
    /** Наименование рыбы */
    private String NameFish;
    /** Особенность - тип рыбы - белая, красная, лососевая, морская, речная ... */
    private String Feature;
    /** Способ обработки - копчёная, вяленная, соленая, свежая ... */
    private String Method;
    /** Размер рыбы - крупная, мелкая, средняя ... */
    private String Size;
    /** стоимость рыбы в рублях*/
    private Double Price;

    /** Коструктор создаёт обект строки таблицы с данными */
    Fish(Integer id, String namefish, String feature, String method, String size, Double price)
    {
        ID = id;
        NameFish = namefish;
        Feature = feature;
        Method = method;
        Size = size;
        Price = price;
    }

    /** Возвращает значение поля ID */
    public Integer getID() {
        return ID;
    }
    /** Задаёт значение поля ID*/
    public void setID(Integer id) {
        if (id >= 0)
            this.ID = id;
        else throw new IllegalArgumentException("Должно быть больше или равно нулю");
    }
    public String getNameFish() {
        return NameFish;
    }
    public void setNameFish (String namefish) {
        this.NameFish = namefish;
    }
    public String getFeature() {
        return Feature;
    }
    public void setFeature(String feature) {
        this.Feature = feature;
    }
    public String getMethod() {
        return Method;
    }
    public void setMethod(String method) {
        this.Method = method;
    }
    public String getSize() {
        return Size;
    }
    public void setSize(String size) { this.Size = size; }
    public Double getPrice() {
        return Price;
    }
    public void setPrice(Double price) {
        this.Price = price;
    }
 }
