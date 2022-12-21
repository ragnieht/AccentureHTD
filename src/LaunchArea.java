import java.util.Scanner;

abstract class Shape {
    float area;
    Scanner s = new Scanner(System.in);
    abstract void acceptInput();
    abstract void compute();
    void display() {
        System.out.println("Area of shape: " + area);
    }

    void init () {
        acceptInput();
        compute();
        display();
    }
}

class Triangle extends Shape {
    float base;
    float height;
    void acceptInput() {
        System.out.println("Please enter base");
        base = s.nextFloat();
        System.out.println("Please enter height");
        height = s.nextFloat();
    }

    void compute() {
        area = base * height * 0.5f;
    }
}

class Rectangle extends Shape{
    float length;
    float breadth;
    void acceptInput() {
        System.out.println("Please enter length");
        length = s.nextFloat();
        System.out.println("Please enter breadth");
        breadth = s.nextFloat();
    }

    void compute() {
        area = length * breadth;
    }
}

class Circle extends Shape {
    float radius;
    void acceptInput() {
        System.out.println("Please enter radius");
        radius = s.nextFloat();
    }

    void compute() {
        area = (float) (3.142f * Math.pow(radius, 2));
    }
}

class Geometry {
    void permit(Shape ref) {
        ref.acceptInput();
        ref.compute();
        ref.display();
    }
}
public class LaunchArea {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        Rectangle r = new Rectangle();
        Circle c = new Circle();

        Geometry g = new Geometry();
        g.permit(t);
        g.permit(r);
        g.permit(c);
//        t.init();
//        r.init();
//        c.init();
    }
}