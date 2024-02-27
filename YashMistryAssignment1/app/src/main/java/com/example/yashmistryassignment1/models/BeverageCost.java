package com.example.yashmistryassignment1.models;

// class
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
    private String selectRegion;
    private String selectedStore;

    private String salesDate;

    private double beverageSizeCost;


    // constructor
    public BeverageCost(String customerName, String email, String phoneNumber, String selectRegion, String salesDate, String beverageType, String beverageFlavour, Double addedflavouringCost, String selectedStore, double milkCost, double sugarCost, double beverageSizeCost, String beverageSize) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.selectRegion = selectRegion;
        this.salesDate = salesDate;
        this.beverageType = beverageType;
        this.beverageFlavour = beverageFlavour;
        this.addedflavouringCost = addedflavouringCost;
        this.selectedStore = selectedStore;
        this.milkCost = milkCost;
        this.sugarCost = sugarCost;
        this.beverageSizeCost = beverageSizeCost;
        this.beverageSize = beverageSize;
    }

    // method
    public String getBeverageCost() {
        double additionalCost = milkCost + sugarCost;
        double subtotal = 0;
        double tax = 0;
        double totalCost = 0;


        // Calculating total cost
        subtotal = beverageSizeCost + additionalCost + addedflavouringCost;
        tax = subtotal * 0.13;
        totalCost = subtotal + tax;

        // Result

        return customerName + ", " + beverageType + ", " + selectRegion + ", " + selectedStore + ", "  + beverageSize+ ", " + beverageFlavour + ", " + salesDate + ", Total: $" + String.format("%.2f", totalCost);
    }
}
