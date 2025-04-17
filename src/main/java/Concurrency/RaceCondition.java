package Concurrency;

/*
Volatile Keyword: While volatile ensures that changes to a variable are visible across threads,
it does not ensure atomicity or thread safety for compound actions like incrementing a variable.
In your case, even if you declare count as volatile, it won't prevent race conditions because
the increment operation is not atomic.
 */
public class RaceCondition {
    private static int count = 0;

    public static void main(String[] args) {
        Thread th1 = new Thread(getRunnable());
        Thread th2 = new Thread(getRunnable());

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(count);
    }

    public static Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        };
    }
}
