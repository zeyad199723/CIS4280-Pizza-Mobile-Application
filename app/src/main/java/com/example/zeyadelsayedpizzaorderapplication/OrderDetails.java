package com.example.zeyadelsayedpizzaorderapplication;

import java.util.Arrays;

public class OrderDetails {
    private String customerName;
    private String phoneNumber;
    private String email;
    private String address;
    private String[] pizzaToppings;
    private String pizzaSize;
    private double orderPrice;

    // Constructor
    public OrderDetails(String customerName, String phoneNumber, String email, String address,
                        String[] pizzaToppings, String pizzaSize) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.pizzaToppings = pizzaToppings;
        this.pizzaSize = pizzaSize;
        this.orderPrice = calculateOrderPrice();
    }

    // Method to calculate order price
    private double calculateOrderPrice() {
        // Define prices for toppings and sizes
        double toppingPrice = 0; // no additional cost for the main toppings
        double sizePrice = 0; // Initialize with default value

        // Assign price based on selected size
        switch (pizzaSize) {
            case "Small":
                sizePrice = 6.99;
                break;
            case "Medium":
                sizePrice = 8.99;
                break;
            case "Large":
                sizePrice = 11.99;
                break;
            case "Party":
                sizePrice = 20.99;
                break;
            // Handle other sizes if needed
        }

        // Calculate total price
        return sizePrice + (toppingPrice * pizzaToppings.length);
    }

    // Getter method for order price
    public double getOrderPrice() {
        return orderPrice;
    }

    // Other getters and setters for customer details

    // Example of toString() method to display order details
    @Override
    public String toString() {
        return "OrderDetails{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", pizzaToppings=" + Arrays.toString(pizzaToppings) +
                ", pizzaSize='" + pizzaSize + '\'' +
                ", orderPrice=" + orderPrice +
                '}';
    }

    // You can add more methods as needed
}