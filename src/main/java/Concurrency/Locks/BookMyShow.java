package Concurrency.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookMyShow {
    private final Lock lock = new ReentrantLock();
    private boolean [] seats;

    public BookMyShow(int total){
        seats = new boolean[total];
        for(int i = 0 ; i < total ; ++i) seats[i] = true;

    }

    public void bookSeat(String customerName, int seatNo){
        if(seatNo < 0 || seatNo > seats.length)
            throw new RuntimeException("invalid booking request");

        lock.lock();
        try {
            if(seats[seatNo]){
                seats[seatNo] = false;
                System.out.println(customerName +
                        " has booked the seat No  " + seatNo);
            }
            else {
                System.out.println("Sorry " + customerName +
                        " Seat is already Booked !");
            }
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow(10);
        Thread customer1 = new Thread(()-> {
            bookMyShow.bookSeat("Avinash",2);
        });
        Thread customer2 = new Thread(() -> {
            bookMyShow.bookSeat("Aditya",2);
        });

        customer1.start();
        customer2.start();
    }
}
