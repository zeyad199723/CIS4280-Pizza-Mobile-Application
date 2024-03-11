package com.example.zeyadelsayedpizzaorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class CustomerPage extends AppCompatActivity {

    private ArrayList<String> selectedToppings;
    private String selectedSize;
    private EditText editTextCustomerName;
    private EditText editTextPhoneNumber;
    private EditText editTextEmail;
    private EditText editTextAddress;
    private TextView textViewReceiptInfo;
    private TextView pizzaSize;
    public static final String SIZE = "datafrommainpizzasize";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
//        pizzaSize= findViewById(R.id.);

        Intent intent = getIntent();
        String test = intent.getStringExtra(SIZE);
//        pizzaSize.setText(test);
        String newtest =  test.replaceAll("\\s*\\$.*", "");

        selectedSize = newtest;
        selectedToppings = intent.getStringArrayListExtra("toppings");
//        selectedSize = intent.getStringExtra("size");
        editTextCustomerName = findViewById(R.id.editTextCustomerName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextAddress = findViewById(R.id.editTextAddress);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewReceiptInfo = findViewById(R.id.textView4);

        buttonSubmit.setOnClickListener(v -> displayReceiptInformation());
    }

    private void displayReceiptInformation() {
        String customerName = editTextCustomerName.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String email = editTextEmail.getText().toString();
        String address = editTextAddress.getText().toString();

        // Calculate total price based on selected toppings, size, and their prices
        double totalPrice = calculateTotalPrice();

        String receiptInfo = "Customer Information:\n" +
                "Name: " + customerName + "\n" +
                "Phone: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n\n" +
                "Pizza Size: " + selectedSize + "\n" +
                "Toppings: " + selectedToppings.toString() + "\n" +
                "Total Price: $" + totalPrice;

        textViewReceiptInfo.setText(receiptInfo);
    }

    // Method to calculate total price
    private double calculateTotalPrice() {
        // Define prices for toppings and sizes
        double toppingPrice = 0; // no additional cost for the main toppings
        double sizePrice = 0; // Initialize with default value

        // Assign price based on selected size
        switch (selectedSize) {
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

        return sizePrice + (toppingPrice * selectedToppings.size());
    }

    public void onHelpClick(View view) {
        Intent intent = new Intent(this, HelpPage.class);
        startActivity(intent);
    }
}
