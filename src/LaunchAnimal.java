class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }

    void sleep() {
        System.out.println("Animal is sleeping");
    }

    void food() {
        System.out.println("Animal eats foods");
    }
}

class Tiger extends Animal {
    void eat() {
        System.out.println("Tiger eats meats");
    }
}

class Deer extends Animal {
    void sleep() {
        System.out.println("Deer sleeps in the night");
    }
}

class Monkey extends Animal {
    void food() {
        System.out.println("Monkey steals food");
    }
}

class Forest {
    void init(Animal a) {
        a.eat();
        a.sleep();
        a.food();
    }
}

public class LaunchAnimal {
    public static void main(String[] args) {
        Tiger t = new Tiger();
        Deer d = new Deer();
        Monkey m = new Monkey();
        Forest f = new Forest();

        f.init(t);
        f.init(d);
        f.init(m);

    }
}
