// Author: Бурдинская Наталья ВМК-22
package RectangleClass;
// Подключении статических функций для тестов
import static org.junit.jupiter.api.Assertions.*;
// Подключение аннотации
import org.junit.jupiter.api.Test;
// Подключаем тестируемый класс
import RectangleClass.Rectangle;

class RectangleTest {

    /** Проверяем методы сеттеры и геттеры */
    @Test
    public void TestClass() {
        // Создание объета класса по умолчанию
        Rectangle Test1 = new Rectangle();
        // Проверка задания координат по умолчанию
        assertEquals(Test1.get_x1(), 0.0);// AX
        assertEquals(Test1.get_y1(), 0.0);// AY
        assertEquals(Test1.get_x2(), 0.0);// BX
        assertEquals(Test1.get_y2(), 0.0);// BY
        assertEquals(Test1.get_x3(), 0.0);// CX
        assertEquals(Test1.get_y3(), 0.0);// CY

        // Проверка конструктора с заданием координат
        Rectangle Test2 = new Rectangle(0.0, 0.0, 4.0, 0.0, 0.0, 6.0);
        assertEquals(Test2.get_x1(), 0.0);// AX
        assertEquals(Test2.get_y1(), 0.0);// AY
        assertEquals(Test2.get_x2(), 4.0);// BX
        assertEquals(Test2.get_y2(), 0.0);// BY
        assertEquals(Test2.get_x3(), 0.0);// CX
        assertEquals(Test2.get_y3(), 6.0);// CY
    }

    /** Проверяем методы поиска длины и ширины прямоугольника */
    @Test
    public void Test_Lengths() {
        // Проверка вычисления длины и ширины прямоугольника
        Rectangle Test1 = new Rectangle(0.0, 0.0, 4.0, 0.0, 0.0, 6.0);
        assertTrue(Math.abs(Test1.SideRectangleA() - 4) < 0.001); // длина = 4
        assertTrue(Math.abs(Test1.SideRectangleB() - 6) < 0.001); // ширина = 6

        // Меняем координаты и ещё раз проверяем
        Rectangle Test2 = new Rectangle(1.0, 1.0, 5.0, 1.0, 1.0, 7.0);
        assertTrue(Math.abs(Test2.SideRectangleA() - 4) < 0.001); // длина = 4
        assertTrue(Math.abs(Test2.SideRectangleB() - 6) < 0.001); // ширина = 6
    }

    /** Проверяем методы периметра и площади прямоугольника */
    @Test
    public void Test_Perimetr_Square() {
        Rectangle Test1 = new Rectangle(0.0, 0.0, 4.0, 0.0, 0.0, 6.0);
        // Проверка вычисления периметра прямоугольника
        assertTrue(Math.abs(Test1.PerimeterAB() - 20) < 0.001); // периметр = 20
        assertTrue(Math.abs(Test1.PerimeterXY() - 20) < 0.001); // периметр = 20
        // Проверка вычисления палощади прямоугольника
        assertTrue(Math.abs(Test1.SquareAB() - 24) < 0.001); // площадь = 24
        assertTrue(Math.abs(Test1.SquareXY() - 24) < 0.001); // площадь = 24

        // Меняем координаты и ещё раз проверяем
        Rectangle Test2 = new Rectangle(1.0, 1.0, 5.0, 1.0, 1.0, 7.0);
        // Проверка вычисления периметра прямоугольника
        assertTrue(Math.abs(Test2.PerimeterAB() - 20) < 0.001); // периметр = 20
        assertTrue(Math.abs(Test2.PerimeterXY() - 20) < 0.001); // периметр = 20
        // Проверка вычисления палощади прямоугольника
        assertTrue(Math.abs(Test2.SquareAB() - 24) < 0.001); // площадь = 24
        assertTrue(Math.abs(Test2.SquareXY() - 24) < 0.001); // площадь = 24
    }

    /** Проверяем метод поиска косинуса угла прямоугольника */
    @Test
    public void Test_Angle() {
        // Проверка вычисления косинуса угла между длиной и шириной прямоугольника
        Rectangle Test1 = new Rectangle(0.0, 0.0, 4.0, 0.0, 0.0, 6.0);
        assertTrue(Math.abs(Test1.AngleRectangle() - 0) < 0.001); // косинус угла = 0

        // Меняем координаты и ещё раз проверяем
        Rectangle Test2 = new Rectangle(1.0, 1.0, 5.0, 1.0, 1.0, 7.0);
        assertTrue(Math.abs(Test2.AngleRectangle() - 0) < 0.001); // косинус угла = 0
    }

    /** Проверяем метод поиска координат 4-ой точки прямоугольника */
    @Test
    public void Test_Сoordinate() {
        // Проверка конструктора с заданием координат
        Rectangle Test1 = new Rectangle(1,1,5,1,1,7);
        assertEquals(Test1.get_x1(),1);// AX
        assertEquals(Test1.get_y1(),1);// AY
        assertEquals(Test1.get_x2(),5);// BX
        assertEquals(Test1.get_y2(),1);// BY
        assertEquals(Test1.get_x3(),1);// CX
        assertEquals(Test1.get_y3(),7);// CY
        // Проверка вычисления координат 4-ой точки
        assertTrue(Math.abs(Test1.СoordinateX4() - 5) < 0.001); // X4 = 5
        assertTrue(Math.abs(Test1.СoordinateY4() - 7) < 0.001); // Y4 = 7

        // Меняем координаты и ещё раз проверяем
        Rectangle Test2 = new Rectangle(0.0, 0.0, 4.0, 0.0, 0.0, 6.0);
        assertTrue(Math.abs(Test2.СoordinateX4() - 4) < 0.001); // X4 = 4
        assertTrue(Math.abs(Test2.СoordinateY4() - 6) < 0.001); // Y4 = 6

        // Проверка вычисления длины диагонали прямоугольника
        assertTrue(Math.abs(Test1.DiagonalRectangle() - 7.2111) < 0.001); // диагональ = 7,2111
        assertTrue(Math.abs(Test2.DiagonalRectangle() - 7.2111) < 0.001); // диагональ = 7,2111
   }
    // Все тесты методов класса выполнены успешно
}