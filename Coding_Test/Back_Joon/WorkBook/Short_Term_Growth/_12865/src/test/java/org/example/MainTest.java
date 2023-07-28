package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static SecureRandom rand; // Use SecureRandom with private static variable in class(not function)

    static { // Because rand is static variable
        try { // try-catch NoSuchAlgorithmException
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static SecureRandom getRand() {
        return rand;
    }

    @DisplayName("over100() : Success function that number is over 100")
    @Test
    void over100() {
        int number = 100;
        int weight = 100;
        int maxValuable = 0;
        Main.Luggage[] luggage = new Main.Luggage[100];

        for (int i = 0; i< 100; i++) {
            int value = rand.nextInt(10);
            luggage[i] = new Main.Luggage(1, value);
            maxValuable += value;
        }



        int max = Main.getMaxValuable(luggage, number, weight);

        assertEquals(maxValuable, max);
    }
}