package Chapter_10.Consultant;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Roundrobin
 */
public class Roundrobin implements Schedular{ // Place them in order, regardless of the consultant.

    int countOfConsultant;
    int countOfCustomer;
    int numberOfWait[]; // number of wait for each consultant.
    Queue<Integer> queue = new LinkedList<>(); // The queue is in the order customer called.
    
    public Roundrobin(int countOfConsultant) {
        this.countOfCustomer = 0;
        this.countOfConsultant = countOfConsultant;
        numberOfWait = new int[countOfConsultant];
    }

    @Override
    public void getNextCall() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendCallToAgent() {
        // TODO Auto-generated method stub
        
    }
}