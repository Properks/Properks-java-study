package org.example;

import java.io.*;
import java.util.*;

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
        int[] dp = new int[totalWeight + 1];
        for (int i = 0; i < number; i++) {

        }

    }
}