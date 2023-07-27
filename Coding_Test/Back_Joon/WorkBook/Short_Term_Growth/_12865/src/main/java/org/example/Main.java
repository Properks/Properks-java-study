package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int maxValuable = 0;
    static Luggage[] luggages;
    static int number;
    static int totalWeight;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        number = Integer.parseInt(stringTokenizer.nextToken());
        totalWeight = Integer.parseInt(stringTokenizer.nextToken());

        luggages = new Luggage[number];

        for (int i = 0; i < number; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            luggages[i] = new Luggage(Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(getMaxValuable(0, 0, 0));

    }

    static class Luggage implements Comparable<Luggage>{
        private int weight;
        private int valuable;

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

        @Override
        public int compareTo(Luggage o) {
            return this.valuable - o.getValuable();
        }
    }

    private static int getMaxValuable(int index, int weight, int sum) {
        if (index >= number) {
            return sum;
        }

        if (weight + luggages[index].getWeight() > totalWeight) {
            return getMaxValuable(index + 1, weight, sum);
        } else {
            return Math.max(getMaxValuable(index+1, weight, sum),
                    getMaxValuable(index + 1,
                            weight + luggages[index].getWeight(),
                            sum + luggages[index].getValuable()));
        }
    }
}