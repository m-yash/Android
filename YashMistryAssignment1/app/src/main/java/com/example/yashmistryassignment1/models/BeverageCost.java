package com.example.yashmistryassignment1.models;

public class BeverageCost {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String beverageType;
    private String beverageFlavour;
    private double milkCost;
    private double sugarCost;
    private String beverageSize;
    private Double addedflavouringCost;
    private String region;
    private String selectedStore;

    private String salesDate;

    private double sizeCost;


    public BeverageCost(String customerName, String email, String phoneNumber, String region, String salesDate, String beverageType, String beverageFlavour, Double addedflavouringCost, String selectedStore, double milkCost, double sugarCost, double sizeCost, String beverageSize) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.salesDate = salesDate;
        this.beverageType = beverageType;
        this.beverageFlavour = beverageFlavour;
        this.addedflavouringCost = addedflavouringCost;
        this.selectedStore = selectedStore;
        this.milkCost = milkCost;
        this.sugarCost = sugarCost;
        this.sizeCost = sizeCost;
        this.beverageSize = beverageSize;
    }

    public String getBeverageCost() {
        double additionalCost = milkCost + sugarCost;
        double subtotal = 0;
        double tax = 0;
        double totalCost = 0;


        // Calculating total cost
        subtotal = sizeCost + additionalCost + addedflavouringCost;
        tax = subtotal * 0.13;
        totalCost = subtotal + tax;

        // Result

        return customerName + ", " + beverageType + ", " + region + ", " + selectedStore + ", "  + beverageSize+ ", " + beverageFlavour + ", " + salesDate + ", Total: $" + String.format("%.2f", totalCost);
    }
}
