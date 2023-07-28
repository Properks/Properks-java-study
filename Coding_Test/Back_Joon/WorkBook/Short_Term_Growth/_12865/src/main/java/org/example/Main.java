package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int number = Integer.parseInt(stringTokenizer.nextToken());
        int totalWeight = Integer.parseInt(stringTokenizer.nextToken());

        Luggage[] luggages = new Luggage[number];

        for (int i = 0; i < number; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            luggages[i] = new Luggage(Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(getMaxValuable(luggages, number, totalWeight));
        br.close();
    }

    static class Luggage {
        private final int weight;
        private final int valuable;

        public Luggage(int weight, int valuable) {
            this.weight = weight;
            this.valuable = valuable;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getValuable() {
            return this.valuable;
        }
    }

    public static int getMaxValuable(Luggage[] luggages, int number, int totalWeight) {
        int maxValue = 0;
        int dpIndex;
        for (int i = 0; i < number; i++) {
            int[] dpValuable = new int[1 << number]; // index error when number is over 100
            int[] dpWeight = new int[1 << number];
            dpIndex = 0;
            dpWeight[dpIndex] = luggages[i].getWeight();
            dpValuable[dpIndex] = luggages[i].getValuable();
            for (int j = i+1; j < number; j++) {
                int currentIndex = dpIndex + 1;
                for (int k = 0; k < currentIndex; k++) {
                    if (dpWeight[k] + luggages[j].getWeight() <= totalWeight) {
                        dpWeight[dpIndex + 1] = dpWeight[k] + luggages[j].getWeight();
                        dpValuable[dpIndex + 1] = dpValuable[k] + luggages[j].getValuable();
                        dpIndex++;
                    }
                }
            }
            maxValue = Math.max(maxValue, Arrays.stream(dpValuable).max().getAsInt());
        }
        return maxValue;
    }
}