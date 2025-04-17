package Concurrency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class TicketBookingSystem {

    // no two people can book a seat at the same time.
    // prevent race condition
    // ensure thread safety while handling concurrent bookings

    private int availableTickets;

    public TicketBookingSystem(int n) {
        this.availableTickets = n;
    }

    public void sleep(int k) {
        try {
            Thread.sleep(k);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized boolean bookTicket(String user, int n) {
        if (n <= availableTickets) {
            System.out.println("We will wait here the Thread is acquired by User " + user);
            sleep(1000);
            System.out.println(user + " booked " + n + " tickets");
            availableTickets = availableTickets - n;
            return true;
        } else {
            System.out.println("Failed to book tickets ");
            return false;
        }

    }

}

class UserThread implements Runnable {

    public TicketBookingSystem bookingSystem;
    private final String userName;
    public int tickets;

    public UserThread(TicketBookingSystem bookingSystem, String userName, int ticketsToBook) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
        this.tickets = ticketsToBook;
    }

    @Override
    public void run() {
        // when we create the thread this method will run and this method should create the object
        bookingSystem.bookTicket(userName, tickets);
    }
}

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        TicketBookingSystem system = new TicketBookingSystem(12);
        Thread thread1 = new Thread(new UserThread(system, "Aditya", 3));
        Thread thread2 = new Thread(new UserThread(system, "Nikhil Banka", 4));

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        System.out.println("Available Tickets now " + system.getAvailableTickets());
    }
}
