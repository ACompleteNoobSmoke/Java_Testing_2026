package com.noobsmoke.exercise;

public class DiscountService {

    public double calculateDiscount(double subtotal, boolean vip) {
        if (vip && subtotal >= 100) {
            return subtotal * 0.15;
        } else if (subtotal >= 200) {
            return subtotal * 0.10;
        }
        return 0.0;
    }
}
