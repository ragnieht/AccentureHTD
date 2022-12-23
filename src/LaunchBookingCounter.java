class BusCounter {
    private int availableSeats = 5;

    public void bookTicket(String name, int seats) {
        if (seats <= availableSeats && seats > 0) {
            System.out.println("Hello " + name + ": " + seats + " tickets are confirmed" );
            availableSeats -= seats;
        } else {
            System.out.println(seats + " not confirmed");
        }
    }
}

class Customer extends Thread {
    String name;
    int seats;
    BusCounter bc;

    public Customer(String name,int seats, BusCounter bc) {
        this.name = name;
        this.seats = seats;
        this.bc = bc;
    }

    public void run() {
        bc.bookTicket(name,seats);
    }
}

public class LaunchBookingCounter {
    public static void main(String[] args) {
        BusCounter bc = new BusCounter();
        Customer c1 = new Customer("Zin",2,bc);
        Customer c2 = new Customer("Jack",1,bc);

        c1.start();
        c2.start();
    }
}
