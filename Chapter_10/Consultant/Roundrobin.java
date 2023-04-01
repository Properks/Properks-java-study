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
    Queue<Integer> queueOfCustomer = new LinkedList<>(); // The queue is in the order customer called.
    
    public Roundrobin(int countOfConsultant) {
        this.countOfCustomer = 0;
        this.countOfConsultant = countOfConsultant;
        numberOfWait = new int[countOfConsultant];
    }

    @Override
    public void getNextCall() {
        queueOfCustomer.add(++countOfCustomer); // Add in queue with queue number
    }
    
    @Override
    public void sendCallToAgent() {
        if (queueOfCustomer.peek() == null) { // if queue is empty.
            System.out.println("No one who want to be consulted");
            return;
        }
        else {
            int temp = queueOfCustomer.poll();
            if (countOfConsultant == 0) { // if consultant is 0.
                System.out.println("Today is day off");
                System.exit(-1);
            }
            else {
                for (int i = 0; i < countOfConsultant; i++) {
                    if (((temp - 1) % countOfConsultant) == i) {// send customer to consultant in order
                        numberOfWait[i]++;
                        break;
                    }
                }
            }
        }
    }

    public void showInfo() {
        for (int i = 0; i < countOfConsultant; i++) {
            System.out.println((i + 1) + " : " + numberOfWait[i]);
        }
        System.out.println("Queue : " + queueOfCustomer);
    }
}