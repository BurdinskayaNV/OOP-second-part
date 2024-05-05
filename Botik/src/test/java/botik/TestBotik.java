// Author: Бурдинская Наталья ВМК-22 
package botik;

import static com.example.botik.Bot.getUrlContent;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBotik {
    @Test
    public void TestClass() throws IOException {
        System.out.println("Hello Botik!");
        String HelloCheck = "\\s*[ПРИВ|прив].*";

        String HelloBot = "[А-Яа-я0-9\\s*].*[П|п][Р|р][И|и][В|в][Е|е][Т|т].*";
        String TestHello = "уррра Привет мой золотой";
        System.out.println(TestHello.matches(HelloBot) + " - привет");

        String ByeBot = ".*[П|п][О|о][К|к][А|а].*";
        String TestBye = "пока Коннор!!!";
        System.out.println(TestBye.matches(ByeBot) + " - пока");

        String TimeBot = ".*[К|к][О|о][Т|т][О|о][Р|р][Ы|ы][Й|й].*[Ч|ч][А|а][С|с]\\??.*";
        String TestTime = "Коннор, который час???";
        System.out.println(TestTime.matches(TimeBot) + " - время");

        String DateBot = ".*[К|к][А|а][К|к][О|о][Е|е].*[Ч|ч][И|и][С|с][Л|л][О|о]\\??.*";
        String TestDate = "Коннор, скажи какое сегодня число???";
        System.out.println(TestDate.matches(DateBot) + " - день");

        String DayWeekBot = ".*[К|к][А|а][К|к][О|о][Й|й].*[Д|д][Е|е][Н|н][Ь|ь].*[Н|н][Е|е][Д|д][Е|е][Л|л][И|и]\\??.*";
        String TestDayWeek = "Коннор, скажи день недели пожалуйста";
        System.out.println(TestDayWeek.matches(DayWeekBot) + " - день недели");

        String AllMesBot = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к][О|о].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н][И|и][Й|й].*[О|о][Т|т][П|п][Р|р][А|а][В|в][Л|л][Е|е][Н|н][О|о].*\\??.*";
        String TestAllMes = "Коннор, сколько всего мы отправили сообщений?";
        System.out.println(TestAllMes.matches(AllMesBot) + " - все сообщения");

        String IMesBot = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к][О|о].*[М|м][О|о][И|и][Х|х].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н][И|и][Й|й]\\??.*";
        String TestIMesBot = "Коннор, сколько всего я отправила сообщений?";
        System.out.println(TestIMesBot.matches(IMesBot) + " - мои сообщения");

        String YouMesBot = ".*[С|с][К|к][О|о][Л|л][Ь|ь][К|к][О|о].*[С|с][О|о][О|о][Б|б][Щ|щ][Е|е][Н|н][И|и][Й|й].*[Б|б][О|о][Т|т][А|а]\\??.*";
        String TestYouMesBot = "Коннор, сколько всего ты отправил сообщений?";
        System.out.println(TestYouMesBot.matches(YouMesBot) + " - Коннора сообщения");

        String MultiplicationBot = ".*[У|у][М|м][Н|н][О|о][Ж|ж][И|и][Т|т][Ь|ь].*[0-9\\.]+.*[Н|н][А|а].*[0-9\\.]+.*";
        String TestMultiplicationBot = "Коннор, умножить 12 на 23 помоги";
        System.out.println(TestMultiplicationBot.matches(MultiplicationBot) + " - умножение");

        String DelenieBot = ".*[Р|р][А|а][З|з][Д|д][Е|е][Л|л][И|и][Т|т][Ь|ь].*[0-9\\.]+.*[Н|н][А|а].*[0-9\\.]+.*";
        String TestDelenieBot = "Коннор, разделить 43 на 21 помоги";
        System.out.println(TestDelenieBot.matches(DelenieBot) + " - деление");

        String SumBot = ".*[С|с][Л|л][О|о][Ж|ж][И|и][Т|т][Ь|ь].*[0-9\\.]+.*[И|и].*[0-9\\.]+.*";
        String TestSumBot = "Коннор, сложить 12.3 и 45.67 помоги";
        System.out.println(TestSumBot.matches(SumBot) + " - сумма");

        String VichiyanieBot = ".*[В|в][Ы|ы][Ч|ч][Е|е][С|с][Т|т][Ь|ь].*[0-9\\.]+.*[И|и][З|з].*[0-9\\.]+.*";
        String TestVichiyanieBot = "Коннор, вычесть 12 из 23 помоги";
        System.out.println(TestVichiyanieBot.matches(VichiyanieBot) + " - вычитание");

        String NumberBot = "\\s?[0-9\\.]+\\s?";
        String TestNumber = "42.56";
        System.out.println(TestNumber.matches(NumberBot) + " - число");

        String WeatherBot = ".*[К|к][А|а][К|к][А|а][Я|я].*[П|п][О|о][Г|г][О|о][Д|д][А|а]\\??.*";
        String TestWeatherBot = "Какая сегодня погода ???";
        System.out.println(TestWeatherBot.matches(WeatherBot) + " - погода");

        // Погода
        String BetWeen = getUrlContent("http://api.openweathermap.org/data/2.5/find?q=Chita&type=like&APPID=8521803bf05ecdbc06f418e022fbe365");
        String ResultTemp = "";
        if (!BetWeen.isEmpty()){
            JSONObject MainObject = new JSONObject(BetWeen);
            double  temp = MainObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").optDouble("temp");
            ResultTemp = ResultTemp + "Температура в Чите: " + String.format("%.2f",temp - 273.15) + " градусов цельсия";
        }
        System.out.println(ResultTemp);

        // Курсы валют
        String Courses = getUrlContent("https://www.cbr-xml-daily.ru/daily_json.js");
        String ResultCourse= "";
        if (!Courses.isEmpty()){
            JSONObject MainObjectCourses = new JSONObject(Courses);
            ResultCourse = ResultCourse + MainObjectCourses.getJSONObject("Valute").getJSONObject("USD").getDouble("Value");
        }
        System.out.println("Курс доллара: " + ResultCourse + " руб.");

        String Result = getUrlContent("https://apod.nasa.gov/apod/ap240324.html");

        Pattern pattern = Pattern.compile("<a href=\"image.+\"");
        Matcher matcher = pattern.matcher(Result);
        String End = "";
        while (matcher.find()) {
            End = Result.substring(matcher.start(), matcher.end());
        }
        System.out.println(End);
        System.out.println(End.substring(9,End.length() - 1));

        URL url = new URL("https://apod.nasa.gov/apod/"+End.substring(9,End.length() - 1));
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("logo.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);//C:\Users\Дмитрий\OOP\Test
        fos.close();
        rbc.close();
    }
}
