package Chapter_10.Consultant;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leastjob
 */
public class Leastjob implements Schedular{

    int countOfConsultant;
    int countOfCustomer;
    int numberOfWait[]; // number of wait for each consultant.
    Queue<Integer> queueOfCustomer = new LinkedList<>(); // The queue is in the order customer called.

    public Leastjob(int numberOfConsultant) {
        this.countOfConsultant = numberOfConsultant;
        countOfCustomer = 0;
        numberOfWait = new int[countOfConsultant];
    }

    @Override
    public void getNextCall() {
        queueOfCustomer.add(++countOfCustomer);
        
    }
    
    @Override
    public void sendCallToAgent() {
        
        
    }
}