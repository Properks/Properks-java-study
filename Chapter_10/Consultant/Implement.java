package Chapter_10.Consultant;

/**
 * Implement
 */
public class Implement {

    public static void main(String[] args) {
        Leastjob LJ = new Leastjob(5);

        for (int i = 0; i < 30; i++) { // Plus 30 in queue
            LJ.getNextCall();
        }
        
        for (int i = 0; i < 19; i++) { // Distribute 19 customer to each consultant
            LJ.sendCallToAgent();
        }
        LJ.showInfo();

        for (int i = 0; i < 2; i++) { // 2nd, 4th consultant's two consulting is done 
            LJ.consultIsEnd(2);
            LJ.consultIsEnd(4);
        }
        LJ.showInfo();
            
        for (int i = 0; i < 3; i++) { // Print how to add customer to consultant.
            LJ.sendCallToAgent();
            System.out.println("====" + (i + 1) + " / 3====");
            LJ.showInfo();
        }
    }
}