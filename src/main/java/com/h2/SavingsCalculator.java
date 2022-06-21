package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits() {
        float sum = 0.0f;
        for (float credit : credits) {
            sum += credit;
        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;
        for (float credit : credits) {
            sum += credit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    public static void main(String[] args) {
        String[] creditsAsStrings = args[0].split(",");
        String[] debitsAsStrings = args[1].split(",");
        float[] credits = new float[creditsAsStrings.length];
        float[] debits = new float[debitsAsStrings.length];
        for (int i = 0; i < creditsAsStrings.length; i++) {
            credits[i] = Float.parseFloat(creditsAsStrings[i]);
        }
        for (int i = 0; i < debitsAsStrings.length; i++) {
            debits[i] = Float.parseFloat(debitsAsStrings[i]);
        }

        SavingsCalculator savingCalculator = new SavingsCalculator(credits, debits);
        float netSavings = savingCalculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

}
