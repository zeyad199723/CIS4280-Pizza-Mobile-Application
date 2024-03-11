package com.example.zeyadelsayedpizzaorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> selectedToppings = new ArrayList<>();
    private String selectedSize = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Restore state if available
        if (savedInstanceState != null) {
            selectedToppings.addAll(savedInstanceState.getStringArrayList("selectedToppings"));
           selectedSize = savedInstanceState.getString("selectedSize");
        }

        Button button = findViewById(R.id.button);



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
         //Save state to bundle
        if(selectedToppings!=null) {
        outState.putStringArrayList("selectedToppings", selectedToppings);
        outState.putString("selectedSize", selectedSize); }
    }

    private void populateSelectedToppings() {
        selectedToppings.clear();
        CheckBox checkBox = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);

        if (checkBox.isChecked()) {
            selectedToppings.add("Pepperoni");
        }

        if (checkBox2.isChecked()) {
            selectedToppings.add("Chicken");
        }
        if (checkBox3.isChecked()) {
            selectedToppings.add("Mushroom");
        }
        if (checkBox5.isChecked()) {
            selectedToppings.add("Green Pepper");
        }
        if (checkBox4.isChecked()) {
            selectedToppings.add("Extra Cheese");
        }
    }

    public void onHelpClick(View v) {
        Intent intent = new Intent(MainActivity.this, HelpPage.class);
        startActivity(intent);
    }

    public void OnNextPage(View v) {
        populateSelectedToppings();
        Intent intent = new Intent(MainActivity.this, CustomerPage.class);
        intent.putStringArrayListExtra("toppings", selectedToppings);
       RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        selectedSize = selectedRadioButton.getText().toString();
         intent.putExtra(CustomerPage.SIZE, selectedSize);
        startActivity(intent);
    }
}
