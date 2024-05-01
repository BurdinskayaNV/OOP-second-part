package com.example.botik;

import java.text.SimpleDateFormat;
import java.util.Date;

// класс Message сообщение
public class Message {
    // имя пользователя
    private String UserName;
    // текст сообщения
    private String Message;
    // дата отправления сообщения
    private Date date;
    // конструктор сообщения, где date дата
    public Message(String userName,String message){
        UserName = userName;
        Message = message;
        date = new Date();
    }
    // конструктор сообщения, где date время
    public Message(String userName,String message, long time){
        UserName = userName;
        Message = message;
        date = new Date(time);
    }
    // получить текст сообщения
    public String getMessage() { return Message; }
    // получить дату отправки сообщения
    public Date getDate() { return date; }
    // получить имя отправителя
    public String getUserName() { return UserName; }

    @Override
    // перевод тип дата в тип скрока в формате "dd.MM.YYYY H:mm"
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YYYY H:mm");
       // return formatter.format(date) + " " + getUserName() + ": " + Message;
        return formatter.format(date) + " " + UserName + ": " + Message;
    }
}
