package Client;

import java.util.LinkedList;
import java.util.Queue;

// Assume that there is a printer management system. Which manage multiple processes to perform printing operation.
// Use a data structure (linked list, Stack, queue etc. ( Whichever you are comfortable with) to display execution
// of processes based on which process was created first (FIFO principle).
//Measuring criteria

// lets say the printer takes the Strings and then print it
// FIFO means first in first out so it should be like Queue
// we create a linked List having values and nodes and the index

class PrintJob {

    private String jobName;

    public PrintJob(String jobName) {
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }
}

class PrinterManager {
    private Queue<PrintJob> printQueue;

    public PrinterManager() {
        printQueue = new LinkedList<>();
    }

    public void addPrintJob(PrintJob job) {
        printQueue.offer(job);
        System.out.println("Added job: " + job.getJobName());
    }

    public void executePrintJob() {
        if (printQueue.isEmpty()) {
            System.out.println("No print jobs in the queue.");
        } else {
            PrintJob job = printQueue.poll();
            System.out.println("Executing job: " + job.getJobName());
        }
    }
}

public class PrinterManagementSystem {
    public static void main(String[] args) {
        PrinterManager printerManager = new PrinterManager();
        printerManager.addPrintJob(new PrintJob("Job1"));
        printerManager.addPrintJob(new PrintJob("Job2"));
        printerManager.addPrintJob(new PrintJob("Job3"));

        // Execute print jobs
        printerManager.executePrintJob();
        printerManager.executePrintJob();
        printerManager.executePrintJob();
        printerManager.executePrintJob(); // This will display "No print jobs in the queue."
    }
}
