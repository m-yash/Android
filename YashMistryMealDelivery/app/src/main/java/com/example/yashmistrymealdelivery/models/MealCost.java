package com.example.yashmistrymealdelivery.models;

// class
public class MealCost {
    private String customerName;
    private String phoneNumber;

    private String subcriptionPlanType;
    private String PlanType;
    private double planTypeCost;
    private double lemonade3L;
    private double milk4L;

    private String typeOfDelivery;
    private double typeOfDeliveryCost;
    private String salesDate;




    // constructor
    public MealCost(String customerName, String phoneNumber, String subcriptionPlanType, String PlanType, double planTypeCost, double milk4L, double lemonade3L, String typeOfDelivery, Double typeOfDeliveryCost, String salesDate) {
        this.customerName = customerName;

        this.phoneNumber = phoneNumber;
        this.subcriptionPlanType = subcriptionPlanType;

        this.PlanType = PlanType;
        this.planTypeCost = planTypeCost;
        this.lemonade3L = lemonade3L;
        this.milk4L = milk4L;
        this.typeOfDelivery = typeOfDelivery;
        this.typeOfDeliveryCost = typeOfDeliveryCost;
        this.salesDate = salesDate;
    }

    // method
    public String getMealCost() {
        double additionalCost = lemonade3L + milk4L;
        double subtotal = 0;
        double totalCost = 0;


        // Calculating total cost
        subtotal = planTypeCost + additionalCost + + typeOfDeliveryCost;
        totalCost = subtotal;

        // Result
        return customerName + ", " + PlanType + ", " + salesDate + ", Total: $" + String.format("%.2f", totalCost) + " CAD";
    }
}

