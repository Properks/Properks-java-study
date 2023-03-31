package Chapter_10.Consultant;

/**
 * Implement
 */
public class Implement {

    public static void main(String[] args) {
        Roundrobin RR = new Roundrobin(3);

        RR.getNextCall();
        RR.getNextCall();
        RR.getNextCall();
        RR.getNextCall();
        RR.showInfo();

        RR.sendCallToAgent();
        RR.sendCallToAgent();
        RR.showInfo();

        RR.sendCallToAgent();
        RR.sendCallToAgent();
        RR.showInfo();

        RR.sendCallToAgent();
        RR.showInfo();
    }
}