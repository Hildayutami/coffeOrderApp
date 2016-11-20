package com.example.example.coffeeorderapp;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
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
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    private int calculatePrice (){
        int price = quantity * 50000;
        return price;
    }

    private String createOrderSummary(int price){
        String priceMessage = "Name : Hilda";
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
        TextView prieTextView = (TextView) findViewById(R.id.order_summary_textview);
        prieTextView.setText(message);
    }



}
