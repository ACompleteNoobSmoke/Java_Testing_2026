package com.noobsmoke.exercise;

public class OrderService {

    private final DiscountService discountService = new DiscountService();
    private final TaxService taxService = new TaxService();
    private final ShippingService shippingService = new ShippingService();

    public double calculateTotal(double itemPrice, int quantity, boolean vipCustomer) {
        double subtotal = itemPrice * quantity;
        double discount = discountService.calculateDiscount(subtotal, vipCustomer);
        double tax = taxService.calculateTax(subtotal - discount);
        double shipping = shippingService.getShippingCost(subtotal - discount);
        return subtotal - discount + tax + shipping;
    }
}
