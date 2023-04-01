package Chapter_10.Consultant;

import java.io.IOException;

/**
 * Implement
 */
public class Implement {

    public static void main(String[] args) throws IOException {
        System.out.println("R : Distribute customer to each consultant fairly");
        System.out.println("L : Distribute customer to consultant with the fewest customer");
        int ch = System.in.read();
        Schedular systemOfDistribution = null;

        if (ch == 'R' || ch == 'r') {
            systemOfDistribution = new Roundrobin(5);
        }
        else if (ch == 'L' || ch == 'l') {
            systemOfDistribution = new Leastjob(5);
        }
        else {
            System.err.println("I don't have this form " + "\'" + ch + "\'");
            return;
        }

        for (int i = 0; i < 30; i++) { // Plus 30 in queue
            systemOfDistribution.getNextCall();
        }
        
        for (int i = 0; i < 19; i++) { // Distribute 19 customer to each consultant
            systemOfDistribution.sendCallToAgent();
        }
        System.out.println("Add is done=========================");
        systemOfDistribution.showInfo();

        for (int i = 0; i < 2; i++) { // 2nd, 4th consultant's two consulting is done 
            systemOfDistribution.consultIsEnd(2);
            systemOfDistribution.consultIsEnd(4);
        }
        System.out.println("Delete is done=========================");
        systemOfDistribution.showInfo();
            
        for (int i = 0; i < 3; i++) { // Print how to add customer to consultant.
            systemOfDistribution.sendCallToAgent();
            System.out.println("====" + (i + 1) + " / 3====");
            systemOfDistribution.showInfo();
        }
    }
}