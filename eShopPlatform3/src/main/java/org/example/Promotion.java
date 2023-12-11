package org.example;

class Promotion {
private Product product;
private double discountPercent;
private int durationDays;

public Promotion(Product product, double discountPercent, int durationDays) {
        this.product = product;
        this.discountPercent = discountPercent;
        this.durationDays = durationDays;
        }

public double getDiscountPercent() {
        return discountPercent;
        }

public int getDurationDays() {
        return durationDays;
        }

public void extendDuration(int additionalDays) {
        if (additionalDays > 0) {
        durationDays += additionalDays;
        System.out.println("Promotion extended by " + additionalDays + " days.");
        } else {
        System.out.println("Invalid number of additional days. Please provide a positive value.");
        }
        }

        }