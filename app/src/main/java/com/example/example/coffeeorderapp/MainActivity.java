package com.example.example.coffeeorderapp;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this method called when the order button is clicked
    public void submitOrder(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name_edittext);
        String name = nameEditText.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_crem_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate =  chocolate.isChecked();
        Log.d("whipped cream", String.valueOf(hasWhippedCream));

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    private int calculatePrice (boolean addWhippedCream, boolean addChocolate){
        int basePrice = 50000;

        if (addWhippedCream){
            basePrice = basePrice + 10000;
        }

        if (addChocolate){
            basePrice = basePrice + 20000;
        }

        return quantity * basePrice;
    }

    private String createOrderSummary(String name, int price, boolean addWhippedcream, boolean addChocolate){
        String priceMessage = "Name : " + name;
        priceMessage = priceMessage + "\n Add whipped cream ? " + addWhippedcream;
        priceMessage = priceMessage + "\n Add chocolate ? " + addChocolate;
        priceMessage = priceMessage + "\nQuantity : " + quantity ;
        priceMessage = priceMessage + "\nTotal : Rp. " + price ;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    //display the given quantity value on the screen
    private void displayQuantity(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_textview);
        quantity.setText("" + number);
    }

    public void increament(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decreament(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_textview);
        priceTextView.setText(message);
    }



}
