package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {

    final public static Map<Integer, Float> bestRates = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Enter the loan term in years: ");
        int loanTermInYears = scanner.nextInt();

        float bestRate = getRates(loanTermInYears);

        if (Math.abs(bestRate - 0.0f) < 0.00000001) {
            System.out.println("No available rates for term: " + loanTermInYears + " years");
        } else System.out.println("Best Available Rate: " + getRates(loanTermInYears) + "%");
    }

    public static float getRates(int loanTermInYears) {
        return bestRates.getOrDefault(loanTermInYears, 0.0f);
    }
}
