interface Interface1 {
    int add(int x, int y);
}

interface Interface2 {
    int sub(int x,int y);
}
class LaunchInterface {
    public static void main(String[] args) {
        Interface2 ref = (x, y) -> y-x;
        System.out.println(ref.sub(10,20));
    }
}
