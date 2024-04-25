// Author: Бурдинская Наталья ВМК-22
// Класс Прямоугольник
package RectangleClass;

public class Rectangle {
    // поля класса:
    private double x1; // координаты x и y первой точки
    private double y1; // координаты x и y первой точки
    private double x2; // координаты x и y второй точки
    private double y2; // координаты x и y второй точки
    private double x3; // координаты x и y третьей точки
    private double y3; // координаты x и y третьей точки

    //Подключение assert:
    //MainApplicatoin/Edit Configurations/Modify Options/Add VM options/Program Arguments/-ea
    // Каждый объект наследуется от класса

    // Конструктор прямоугольника
    public Rectangle()
    { x1 = 0; y1 = 0; x2 = 0; y2 = 0; x3 = 0; y3 = 0; }
    // Конструктор с заданием координат вершин
    Rectangle(double x1_, double y1_, double x2_, double y2_, double x3_, double y3_)
    { set_x1(x1_); set_y1(y1_); set_x2(x2_); set_y2(y2_); set_x3(x3_); set_y3(y3_); }
    // геттеры координаты x и y i-ой точки прямоугольника
    // возвращаем координаты точек
    public double get_x1() { return this.x1; }
    public double get_y1() { return this.y1; }
    public double get_x2() { return this.x2; }
    public double get_y2() { return this.y2; }
    public double get_x3() { return this.x3; }
    public double get_y3() { return this.y3; }
    // сеттеры координаты x и y i-ой точки прямоугольника
    // задает координаты точек
    public void set_x1(double x_1) {
        String x = "" + x_1;
       //if (x.isEmpty()) /// не надо
         //   throw new NullPointerException("x_1 не задано");
        // throw new IllegalArgumentException("x_1 не задано");
        this.x1 = x_1;
    }
    public void set_y1(double y_1) {
        // if (y_1 is Null)
        //    throw new IllegalArgumentException("");
        this.y1 = y_1;
    }
    public void set_x2(double x_2) {
        // if (x_2 is Null)
        //    throw new IllegalArgumentException("");
        this.x2 = x_2;
    }
    public void set_y2(double y_2) {
        // if (y_2 is Null)
        //    throw new IllegalArgumentException("");
        this.y2 = y_2;
    }
    public void set_x3(double x_3) {
        // if (x_3 is Null)
        //    throw new IllegalArgumentException("");
        this.x3 = x_3;
    }
    public void set_y3(double y_3) {
        // if (y_3 is Null)
        //    throw new IllegalArgumentException("");
        this.y3 = y_3;
    }
    // Операция: Нахождение длины стороны A прямоугольника
    public double SideRectangleA()
    {
        //формула длины стороны прямоугольника через координаты двух точек
        return Math.sqrt (Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2));
    }
    // Операция: Нахождение длины стороны B прямоугольника
    public double SideRectangleB()
    {
        //формула длины стороны прямоугольника через координаты двух точек
        return Math.sqrt(Math.pow((this.x3 - this.x1), 2) + Math.pow((this.y3 - this.y1), 2));
    }
    // Операция: Нахождение угла между сторонами
    /** Вычисляем значение углов через координаты 3-х точек (x1,y1),(x2,y2),(x3,y3)
     *   A1(x3,y3)   B1(x4,y4)
     *	 |-----------|
     *	 |           |
     *	 |-----------|
     *	 A(x1,y1)    B(x2,y2)
     * по этому примеру, в нашей функции первыми формальными параметрами будут координаты вершины угла
     * причем (x1,y1) вершина угла angle_a(A1 A B),
     * координаты векторов АА1(х3-х1,у3-у1) и АВ(х2-х1,у2-у1)
     * скалярное произведение (АА1,АВ) будет (х3-х1)*(х2-х1)+(у3-у1)*(у2-у1)
     * длины сторон |АА1| и |AB| можно будет найти по нашей функции SideRectangle
     * тогда cos(angle_a)= (АА1,АВ)/(SideRectangle(х1,y1,x3,y3)*SideRectangle(х1,y1,x2,y2))
     * нам не обязательно переводить угол в градусы
     * у нас прямоугольник, значит угол 90 градусов
     * достаточно будет показать, что косинус 90 равен 0
     */
    public double  AngleRectangle()
    {

        // вычисляем координаты первого вектора между точками (x1,y1) и (x2,y2)
        double x2x1 = x2 - x1;
        double y2y1 = y2 - y1;
        // вычисляем координаты второго вектора между точками (x1,y1) и (x3,y3)
        double x3x1 = x3 - x1;
        double y3y1 = y3 - y1;
        // находим скалярное произведение этих векторов
        double scalar = x2x1 * x3x1 + y2y1 * y3y1;
        // находим косинус угла
        return scalar / (SideRectangleA() * SideRectangleB());
    }

    // Операция: Нахождение координаты X четвертой точки прямоугольника
    public double СoordinateX4()
    {
        double angle_a = AngleRectangle();
        // если угол при вершине (x1,y1) равен 90 градусов
        // значит косинус 90 градусов 0
        if (angle_a != 0)
            throw new IllegalArgumentException("Это не прямоугольник");
        return x1 + (x2 - x1) + (x3 - x1);
    }

    // Операция: Нахождение координаты Y четвертой точки прямоугольника
    public double СoordinateY4()
    {
        double angle_a = AngleRectangle();
        // если угол при вершине (x1,y1) равен 90 градусов
        // значит косинус 90 градусов 0
        if (angle_a != 0)
            throw new IllegalArgumentException("Это не прямоугольник");
        return y1 + (y2 - y1) + (y3 - y1);
    }

    // Операция: Нахождение длины диагонали прямоугольника через координаты
    public double DiagonalRectangle()
    {
        //формула длины диагонали прямоугольника через координаты двух точек
        return Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
    }

    // Операция: Расчет периметра P прямоугольника через длины сторон
    public double PerimeterAB()
    {
        double a = SideRectangleA();
        double b = SideRectangleB();
        return 2 * a + 2 * b;
    }

    // Операция: Расчет площади S прямоугольника через длины сторон
    public double SquareAB()
    {
        double a = SideRectangleA();
        double b = SideRectangleB();
        return a * b;
    }

    // Операция: Расчет периметра P прямоугольника через координаты точек
    public double PerimeterXY()
    {
        return 2 * SideRectangleA() + 2 * SideRectangleB();
    }

    // Операция: Расчет площади S прямоугольника через координаты точек
    public double SquareXY()
    {
        return SideRectangleA() * SideRectangleB();
    }
}

