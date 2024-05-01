// Author: Бурдинская Наталья ВМК-22
package com.example.botik;

import java.io.*;
import java.net.URL;                //
import java.net.URLConnection;      //
import java.nio.channels.Channels;  //
import java.nio.channels.ReadableByteChannel; //
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;     //
import java.util.regex.Pattern;     //
import java.io.BufferedReader;    //**
import java.io.IOException;       //**
import java.io.InputStream;       //**
import java.io.InputStreamReader; //**

import org.json.JSONObject;       //

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

// класс бот
public class Bot {

    // имя пользователя
    public String UserName;
    // площадь сообщений
    public static Message[] ArrayMessages;
    // количество сообщений
    public static int CountMessages;

    // Регулярные выражения: Для проверки на разные сообщения
    private static final String CheckHello = ".*[П|п][Р|р][И|и][В|в][Е|е][Т|т].*";
    private static final String CheckBye = ".*[П|п][О|о][К|к][А|а].*";
    private static final String CheckTime = ".*[К|к][О|о][Т|т][О|о][Р|р][Ы|ы][Й|й].*[Ч|ч][А|а][С|с]\\??.*";
    private static final String CheckDate = ".*[К|к][А|а][К|к][О|о][Е|е].*[Ч|ч][И|и][С|с][Л|л][О|о]\\??.*";
    private static final String CheckWeekDay = ".*[К|к][А|а][К|к][О|о][Й|й].*[Д|д][Е|е][Н|н][Ь|ь].*[Н|н][Е|е][Д|д][Е|е][Л|л][И|и]\\??.*";
    private static final String CheckAllMessages = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к][О|о].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н][И|и][Й|й].*[О|о][Т|т][П|п][Р|р][А|а][В|в][Л|л][Е|е][Н|н][О|о].*\\??.*";
    private static final String CheckIMessage = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к][О|о].*[М|м][О|о][И|и][Х|х].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н][И|и][Й|й]\\??.*";
    private static final String CheckBotMessage = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к][О|о].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н][И|и][Й|й].*[Б|б][О|о][Т|т][А|а]\\??.*";
    private static final String CheckMul = ".*[У|у][М|м][Н|н][О|о][Ж|ж][И|и][Т|т][Ь|ь].*[0-9\\.]+.*[Н|н][А|а].*[0-9\\.]+.*";
    private static final String CheckDiv = ".*[Р|р][А|а][З|з][Д|д][Е|е][Л|л][И|и][Т|т][Ь|ь].*[0-9\\.]+.*[Н|н][А|а].*[0-9\\.]+.*";
    private static final String CheckSum = ".*[С|с][Л|л][О|о][Ж|ж][И|и][Т|т][Ь|ь].*[0-9\\.]+.*[И|и].*[0-9\\.]+.*";
    private static final String CheckSub = ".*[В|в][Ы|ы][Ч|ч][Е|е][С|с][Т|т][Ь|ь].*[0-9\\.]+.*[И|и][З|з].*[0-9\\.]+.*";
    private static final String CheckNumber = "\\s?[0-9\\.]+\\s?";
    private static final String CheckWeather = ".*[К|к][А|а][К|к][А|а][Я|я].*[П|п][О|о][Г|г][О|о][Д|д][А|а]\\??.*";
    private static final String CheckCourseUSD = ".*[К|к][А|а][К|к][О|о][Й|й].*[К|к][У|у][Р|р][С|с].*[Д|д][О|о][Л|л][Л|л][А|а][Р|р][А|а]\\??.*";
    private static final String CheckPicture = ".*[С|с][К|к][А|а][Ч|ч][А|а][Й|й].*[К|к][А|а][Р|р][Т|т][И|и][Н|н][К|к][У|у].*";
    private static final String CheckMayKontact = ".*[М|м][О|о][Я|я].*[С|с][Т|т][Р|р][А|а][Н|н][И|и][Ц|ц][А|а].*";
    private static final String CheckHelp = ".*[П|п][О|о][М|м][О|о][Щ|щ][Ь|ь].*";

    // Конструктор бота
    Bot(String userName) {
        ArrayMessages = new Message[200];
        CountMessages = 0;
        UserName = userName;
    }

    // Открытие диалога из файла и вывод его в окно контроллера
    public void OpenDialogFromFile(BotikWindowController A) {
        String username, mes;
        long time;
        String FileName = UserName + ".txt";
        try (DataInputStream dos = new DataInputStream(new FileInputStream(FileName))) {
            while (dos.available() != 0) {
                username = dos.readUTF();
                mes = dos.readUTF();
                time = dos.readLong();
                ArrayMessages[CountMessages] = new Message(username, mes, time);
                A.AppendMessageInTextArea(ArrayMessages[CountMessages].toString());
                CountMessages++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Добавление сообщения message в массив
    public void AddMessageInArray(String message) {
        ArrayMessages[CountMessages] = new Message(UserName, message);
        CountMessages++;
    }

    // Добавление сообщения message в массив с именем userName
    public void AddMessageInArray(String message, String userName) {
        ArrayMessages[CountMessages] = new Message(userName, message);
        CountMessages++;
    }

    // Возвращает последнее добавленное сообщение в массив
    public String getMessage() {
        return ArrayMessages[CountMessages - 1].toString();
    }

    // Сохранение диалога в файл
    public void SaveDialogInFile() {
        String FileName = UserName + ".txt";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FileName))) {
            for (int i = 0; i < CountMessages; i++) {
                dos.writeUTF(ArrayMessages[i].getUserName());
                dos.writeUTF(ArrayMessages[i].getMessage());
                dos.writeLong(ArrayMessages[i].getDate().getTime());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Добавляет сообщение в массив и обрабатывает его и возвращает ссобщение для вывода в TextArea
    public String addMessage(String message) throws IOException {
        String result = "";

        // Добавление в массив сообщения, которое отправил пользователь
        this.AddMessageInArray(message);

        result = result + this.getMessage() + "\n";

        // Добавление в массив сообщения, которое отправил бот
        try {
            this.AddMessageInArray(BotThink(message), "Коннор");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        result = result + this.getMessage();

        return result;
    }

    // Метод обрабатывает сообщение message
    public static String BotThink(String message) throws Exception {

        Date date = ArrayMessages[CountMessages - 1].getDate();

        if (message.matches(CheckHelp)) {
            return "Коннор может помочь :\n" +
                    " - Который час?\n" +
                    " - Какое число?\n" +
                    " - Какой день недели?\n" +
                    " - Сколько сообщений отправлено?\n" +
                    " - Сколько моих сообщений?\n" +
                    " - Сколько сообщений бота?\n" +
                    " - Умножить * на *\n" +
                    " - Разделить * на *\n" +
                    " - Сложить * и *\n" +
                    " - Вычесть * из *\n" +
                    " - Какая погода?\n" +
                    " - Какой курс доллара?\n" +
                    " - Скачай картинку\n" +
                    " - Моя страница\n";
        }

        if (message.matches(CheckHello)) {
            return HelloBot();
        }

        if (message.matches(CheckBye)) {
            return ByeBot();
        }

        if (message.matches(CheckTime)) {
            return TimeBot(date);
        }

        if (message.matches(CheckDate)) {
            return DateBot(date);
        }

        if (message.matches(CheckWeekDay)) {
            return DayWeekBot(date);
        }

        if (message.matches(CheckAllMessages)) {
            return Integer.toString(CountMessages + 1);
        }

        if (message.matches(CheckIMessage)) {
            return Integer.toString(CountMessages / 2 + 1);
        }

        if (message.matches(CheckBotMessage)) {
            return Integer.toString(CountMessages / 2 + 1);
        }

        if (message.matches(CheckMul)) {
            return MultiplicationBot(message);
        }

        if (message.matches(CheckDiv)) {
            return DivisionBot(message);
        }

        if (message.matches(CheckSum)) {
            return SumBot(message);
        }

        if (message.matches(CheckSub)) {
            return SubtractionBot(message);
        }

        if (message.matches(CheckWeather)) {
            return WeatherBot(message);
        }

        if (message.matches(CheckCourseUSD)) {
            return CourseBot();
        }

        if (message.matches(CheckPicture)){
            DownloadPictureApodBot(date);
            return "Скачано";
        }

        if (message.matches(CheckMayKontact)){
            MayKontactBot();
            return "Запущена";
        }

        return "Я не понимаю, напиши ПОМОЩЬ, чтобы узнать,что может Коннор!";
    }

    // Приветствие с ботом
    public static String HelloBot() {
        int i = (int) (Math.random() * 4);
        return switch (i) {
            case 1 -> "Очень рад вам!";
            case 2 -> "Здравствуйте!";
            case 3 -> "Добрый день!";
            case 4 -> "Приветствую";
            default -> "Привет!";
        };
    }

    // Прощание с ботом
    public static String ByeBot() {
        int i = (int) (Math.random() * 4);
        return switch (i) {
            case 1 -> "Всего хорошего!";
            case 2 -> "До свидания!";
            case 3 -> "До скорого!";
            case 4 -> "До встречи!";
            default -> "Пока!";
        };
    }

    // Возвращает сколько сейчас времени по шаблону "HH:mm"
    public static String TimeBot(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);
    }

    // Возвращает дату по шаблону "dd.MM.YYYY"
    public static String DateBot(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

    // Возвращает день недели по шаблону "dd EEEE"
    public static String DayWeekBot(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        return "Сегодня " + formatter.format(date);
    }

    // Операция умножения ботом
    public static String MultiplicationBot(String message) {
        StringTokenizer tokenizer = new StringTokenizer(message);
        double result = 1;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();

        for (int i = 1; i <= CountTokens; i++) {
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)) {
                result = result * Double.parseDouble(BetWeen);
            }
        }
        return Double.toString(result);
    }

    // Операция деления ботом
    public static String DivisionBot(String message) {
        StringTokenizer tokenizer = new StringTokenizer(message);
        double second = 0, ferst = 0, check = 0;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();

        for (int i = 1; i <= CountTokens; i++) {
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)) {
                if (check == 0) {
                    ferst = Double.parseDouble(BetWeen);
                    check++;
                } else {
                    second = Double.parseDouble(BetWeen);
                }
            }
        }
        return Double.toString(ferst / second);
    }

    // Операция суммирования ботом
    public static String SumBot(String message) {
        StringTokenizer tokenizer = new StringTokenizer(message);
        double result = 0;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();
        for (int i = 1; i <= CountTokens; i++) {
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)) {
                result = result + Double.parseDouble(BetWeen);
            }
        }
        return Double.toString(result);
    }

    // Операция вычитания ботом
    public static String SubtractionBot(String message) {
        StringTokenizer tokenizer = new StringTokenizer(message);
        double second = 0, ferst = 0, check = 0;
        String BetWeen = "";

        int CountTokens = tokenizer.countTokens();

        for (int i = 1; i <= CountTokens; i++) {
            BetWeen = tokenizer.nextToken();
            if (BetWeen.matches(CheckNumber)) {
                if (check == 0) {
                    ferst = Double.parseDouble(BetWeen);
                    check++;
                } else {
                    second = Double.parseDouble(BetWeen);
                }
            }
        }
        return Double.toString(second - ferst);
    }

    // считывание погоды с сайта погоды
    public static String WeatherBot(String message) {
        String BetWeen = getUrlContent("http://api.openweathermap.org/data/2.5/find?q=Chita&type=like&APPID=8521803bf05ecdbc06f418e022fbe365");
        String Result = "";
        if (!BetWeen.isEmpty()) {
            JSONObject object = new JSONObject(BetWeen);
            double temp = object.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
            double feels_temp = object.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("feels_like");
            Result = "Температура: " + String.format("%.2f", temp - 273.15) + " Ощущается: " + String.format("%.2f", feels_temp - 273.15);
        }

        return Result;
    }

   public static void MayKontactBot() throws IOException {
        String result = downloadWebPage("https://vk.com");
        System.out.println(result);
   }

    // Обработка URL адреса и получение данных с него
    public static String getUrlContent(String urlAdress) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Такой город был не найден!");
        }
        return content.toString();
    }

    // Считывание курса доллара
    private static String CourseBot() {
        String Courses = getUrlContent("https://www.cbr-xml-daily.ru/daily_json.js");
        String ResultCourse = "";
        if (!Courses.isEmpty()) {
            JSONObject MainObjectCourses = new JSONObject(Courses);
            ResultCourse = ResultCourse + MainObjectCourses.getJSONObject("Valute").getJSONObject("USD").getDouble("Value");
        }
        return "Курс доллара: " + ResultCourse + " руб.";
    }

    // Скачивание картинки с Apod
    private static void DownloadPictureApodBot(Date date) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        //String a = formatter.format(date);
        String a = "041020";

        String Result = getUrlContent("https://apod.nasa.gov/apod/ap" + a + ".html");
        Pattern pattern = Pattern.compile("<a href=\"image.+\"");
        Matcher matcher = pattern.matcher(Result);
        String End = "";
        while (matcher.find()) {
            End = Result.substring(matcher.start(), matcher.end());
        }
        URL url = new URL("https://apod.nasa.gov/apod/"+End.substring(9,End.length() - 1));
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("logo.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);//C:\Users\Дмитрий\OOP\Test
        fos.close();
        rbc.close();
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.addRequestProperty("User","Yandex");
        urlConnection.setReadTimeout(5000);
        urlConnection.setConnectTimeout(5000);
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
