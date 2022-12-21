class Demo1 {
    int a,b;

    Demo1(){
        this(1000,2000);
    }

    Demo1(int a, int b){
        this.b = b;
    }
}

class Demo2 extends Demo1 {
    int c,d;

    Demo2(){
        this(11,22);
    }

    Demo2(int c, int d){
        this.c = c;
        this.d = d;
    }

    Demo2(int c){
        this.c = c;
        d = 1111;
    }
    void disp(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
public class LaunchInheritanceDemo {
    public static void main(String[] args) {
        Demo2 x = new Demo2();
        x.disp();
    }
}
