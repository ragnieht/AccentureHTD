class Warrior extends Thread {
    String resource1 = "knife";
    String resource2 = "gun";
    String resource3 = "bomb";

    public void run() {
        ramuGetResources();
        rajuGetResources();
    }

    public void ramuGetResources() {
        try {
            synchronized (resource1) {
                System.out.println("Ramu get " + resource1);
                Thread.sleep(3000);
            }
            synchronized (resource2) {
                System.out.println("Ramu get " + resource2);
                Thread.sleep(3000);
            }synchronized (resource3) {
                System.out.println("Ramu get " + resource3);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rajuGetResources() {
        try {
            synchronized (resource1) {
                System.out.println("Raju get " + resource1);
                Thread.sleep(3000);
            }
            synchronized (resource2) {
                System.out.println("Raju get " + resource2);
                Thread.sleep(3000);
            }synchronized (resource3) {
                System.out.println("Raju get " + resource3);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class LaunchLock {
    public static void main(String[] args) {
        Warrior w1 = new Warrior();

        w1.start();
    }
}
