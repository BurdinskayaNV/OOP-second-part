package org.example.SimpleBD;

/** Класс строки в таблице Fish */
public class Fish {

    /** ID */
    private Integer ID;

    /** Наименование рыбы */
    private String NameFish;

    /** Особенность - тип рыбы - беллая, красная, лососевая ... */
    private String Feature;

    /** Способ обработки - копчёная, вяленная, соленая ... */
    private String Method;

    /** Вес рыбы */
    private String Weight;

    /** Размер рыбы - крупная мелкая ... */
    private String Size;

    /** стоимость рыбы в рублях*/
    private Double Price;

    /** Коструктор создаёт обект строки таблицы с данными */
    Fish(Integer id, String nameFish, String feature, String method, String weight, String size, Double price){
        ID = id;
        NameFish = nameFish;
        Feature = feature;
        Method = method;
        Weight = weight;
        Size = size;
        Price = price;
    }

    /** Возврашает значение поля ID */
    public Integer getID() {
        return ID;
    }

    /** Задаёт значение поля ID*/
    public void setID(Integer id) {
        if (id >= 0)
            this.ID = id;
        else throw new IllegalArgumentException("Должно быть больше или равно нулю");
        /// else throw new IllegalArgumentException("Must be greater than or equal to zero");
    }
    public String getNameFish() {
        return NameFish;
    }

    public void setNameFish (String nameFish) {
        this.NameFish = nameFish;
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

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        this.Weight = weight;
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
