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
    public void getNextCall() {  // Add customer in queue with queue number
        queueOfCustomer.add(++countOfCustomer);
        
    }
    
    @Override
    public void sendCallToAgent() {
        if (queueOfCustomer.isEmpty()) { // if queue is empty.
            System.err.println("No one who want to be consulted");
        }
        else {
            if (countOfConsultant == 0) { // if consultant is 0.
                System.out.println("Today is day off");
                System.exit(-1);
            }
            else { // send customer to consultant with the fewest customer
                numberOfWait[findMinValue()]++;
            }
        }
        
    }

    public int findMinValue() {
        int temp = 0;
        for (int i = 1; i < numberOfWait.length; i++) {
            if (numberOfWait[temp] > numberOfWait[i]) {
                temp = i;
            }
        }
        return temp;
    }
}