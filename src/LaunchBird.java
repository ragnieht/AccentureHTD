abstract class Bird {
    abstract void eat();
    abstract void fly();
    void info () {
        eat();
        fly();
    }
}

class Sparrow extends Bird {
    void fly() {
        System.out.println("Sparrow flys low and slow");
    }
    void eat() {
        System.out.println("Sparrow eats grains");
    }
}

abstract class Eagle extends Bird {
    void fly() {
        System.out.println("Eagle fly high and fast");
    }
}

class GoldenEagle extends Eagle {
    void eat() {
        System.out.println("Golden Eagle eats mammals");
    }
}

class SerpentEagle extends Eagle {
    void eat() {
        System.out.println("Serpent Eagle eats lizards");
    }
}

class Sky {
    void permit(Bird ref) {
        ref.eat();
        ref.fly();
    }
}
public class LaunchBird {
    public static void main(String[] args) {
        Sparrow s = new Sparrow();
        GoldenEagle ge = new GoldenEagle();
        SerpentEagle se = new SerpentEagle();
        Sky i = new Sky();
        i.permit(s);
        i.permit(ge);
        i.permit(se);

        s.info();
        ge.info();
        se.info();
    }
}
