package com.example.example.coffeeorderapp;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this method called when the order button is clicked
    public void submitOrder(View view) {
       displayPrice(quantity * 50000);
    }

    //display the given quantity value on the screen
    private void display(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_textview);
        quantity.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_tv);
        priceTextView.setText("" + number);
    }

    public void increament(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decreament(View view) {
        quantity = quantity - 1;
        display(quantity);
    }
}
