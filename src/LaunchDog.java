class Dog {
    String name;
    String color;
    int cost;
    static int count;

    {
        count++;
    };
    Dog() {

    }

    Dog(String name) {

        name = name;
    }

    Dog(String name, String color, int cost) {

        name = name;
        color = color;
        cost = cost;
    }
}

public class LaunchDog {
    public static void main(String[] args) {
        System.out.println(Dog.count);
        Dog d1 = new Dog();
        System.out.println(Dog.count);
        Dog d2 = new Dog("Ruby");
        System.out.println(Dog.count);
        Dog d3 = new Dog("Lobo", "White", 1000);
        System.out.println(Dog.count);

    }
}

