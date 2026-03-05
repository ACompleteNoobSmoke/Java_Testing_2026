package com.noobsmoke.exercise;

public class ShippingCostCalculator {

    public double calculate(double weightKG, String region, boolean express) {
        if (weightKG <= 0 || weightKG > 5) throw new IllegalStateException("Incorrect Weight");
        if (region == null || (!region.equalsIgnoreCase("local") && !region.equalsIgnoreCase("international")))
            throw new IllegalStateException("Incorrect Region");

        double base;
        if (weightKG <= 1) base = 5.00;
        else if (weightKG <= 5) base = region.equalsIgnoreCase("local") ? 10.00 : 20.00;
        else base = region.equalsIgnoreCase("local") ? 15.00 : 30.00;
        return express ? base + 15.00 : base;
    }
}
