package Chapter_10.Consultant;

/**
 * Schedular
 */
public interface Schedular {

    void getNextCall();
    void sendCallToAgent();
    void showInfo();
    void consultIsEnd(int consultantNumber);
}