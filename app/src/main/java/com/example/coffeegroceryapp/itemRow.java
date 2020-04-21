package com.example.coffeegroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class itemRow extends AppCompatActivity {

        private int quantity = 0;
         private int price1 = 2000;
    private int price2 = 1500;
    private int price3 = 3000;
    private int price4 = 4000;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        }

        /*
         * This method is called when the plus button is clicked.
         */
        public void increment(View v) {
            if (quantity == 100) {
                //Show an error message
                Toast.makeText(this, "You cannot order more than 100 cups", Toast.LENGTH_SHORT).show();
                return;
            }
            quantity = quantity + 1;
            displayQuantity(quantity);
            displayQuantity2(quantity);
            displayQuantity3(quantity);
            displayQuantity4(quantity);
        }

        /**
         * This method is called when the minus button is clicked.
         */
        public void decrement(View v) {
            if (quantity == 1) {
                //Show an error message
                Toast.makeText(this, "You cannot order less than 1 cup", Toast.LENGTH_SHORT).show();
                return;
            }
            quantity = quantity - 1;

            displayQuantity(quantity);
            displayQuantity2(quantity);
            displayQuantity3(quantity);
            displayQuantity4(quantity);

        }


//         * This method displays the given price on the screen.

//        private void displayPrice(int number) {
//            TextView priceTextView = findViewById(R.id.quantity_text_view);
//            TextView priceTextView1 = findViewById(R.id.quantity_text_view2);
//            TextView priceTextView2 = findViewById(R.id.quantity_text_view3);
//            TextView priceTextView3 = findViewById(R.id.quantity_text_view4);
//
//            if (quantity == 100) {
//
//            }
//
//            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//            price1+=1;
//            displayQuantity(quantity);
//            displayPrice(price1);
//        }

        /**
         * This method is called when the order button is clicked.
         */
        public void submitOrder(View v) {
            EditText nameField =  findViewById(R.id.name_field);
            String name = nameField.getText().toString();

            CheckBox whippedCheckBox =  findViewById(R.id.whipped_cream_checkbox);
            boolean hasWhippedCream = whippedCheckBox.isChecked();

            CheckBox chocolateCheckBox =  findViewById(R.id.chocolate_checkbox);
            boolean hasChocolate = chocolateCheckBox.isChecked();

            CheckBox latteCheckBox =  findViewById(R.id.latte_checkbox);
            boolean hasLatte = latteCheckBox.isChecked();

            CheckBox expressoCheckBox =  findViewById(R.id.expresso_checkbox);
            boolean hasExpresso = expressoCheckBox.isChecked();

//
//            if(whippedCheckBox.isChecked()) {
//                price1 = price1 * quantity;
//
//            }
//            else if (chocolateCheckBox.isChecked()){
//                price2 = price2 * quantity;
//
//            }
//            else if (latteCheckBox.isChecked()){
//
//                price3 = price3 * quantity;
//
//            }
//            else if (expressoCheckBox.isChecked()){
//                price4 = price4 * quantity;
//            }
//            else
//                int price = price1 * price2 * price3 * price4;



            int price = calculatePrice(hasWhippedCream, hasChocolate, hasLatte, hasExpresso);
            String priceMessage = createOrderSummary(price, name, hasWhippedCream, hasChocolate, hasLatte,hasExpresso);


            showToastMessage(
                    "ORDER SUMMARY" + priceMessage + "\n");
            Intent intent = new Intent(itemRow.this, orderSummary.class);
//            intent.putExtra("ORDER SUMMARY", String.valueOf(priceMessage));
            startActivity(intent);
            finish();

        }

        /**
         * Calculates the price of the order
         *
         * @param addChocolateCream is whether a user wants chocolate cream
         * @param addWhippedCream   is whether a user wants whipped cream
         *  @param addLatteCream   is whether a user wants whipped cream
         *  @param addExpressoCream   is whether a user wants whipped cream
         * @return total price
         */
        private int calculatePrice(boolean addWhippedCream, boolean addChocolateCream, boolean addLatteCream, boolean addExpressoCream ) {
            int vatPrice = 5;
            if (addChocolateCream) {
                price2= price2 * quantity;
                vatPrice = vatPrice + 1;
            }
            if (addWhippedCream) {
                price1 = price1 * quantity;
                vatPrice = vatPrice + 1;
            }
            if (addLatteCream) {
                price3= price3 * quantity;
                vatPrice = vatPrice + 1;
            }
            if (addExpressoCream) {
                price4= price4 * quantity;
                vatPrice = vatPrice + 1;
            }
            return vatPrice * quantity;
        }


        /**
         * Printing summary of order
         *
         * @param addChocolateCream is whether a user wants chocolate cream
         * @param name              of the customer
         * @param addWhippedCream   is whether a user wants whipped cream
         *   @param addLatteCream   is whether a user wants latte cream
         *   @param addExpressoCream   is whether a user wants expresso cream
         * @param price             of the order
         * @return text summary
         */
        private String createOrderSummary(int price, String name, boolean addWhippedCream, boolean addChocolateCream, boolean addExpressoCream, boolean addLatteCream ) {
            String priceMessage = "Name:"  + name;
            priceMessage += "\n  Whipped Cream:" + addWhippedCream;
            priceMessage += "\n Chocolate Cream:" + addChocolateCream;
            priceMessage += "\n Expresso:" + addExpressoCream;
            priceMessage += "\n Latte:" + addLatteCream;
            priceMessage += "\n Quantity: " + quantity;
            priceMessage += "\n Total: $" + price;
            priceMessage += "\n " + getString(R.string.thank_you);
            return priceMessage;
        }

        /**
         * This method displays the quantity value on the screen.
         */
        @SuppressLint("SetTextI18n")
        private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);

        quantityTextView.setText(  "" +  numberOfCoffees);

    }

    @SuppressLint("SetTextI18n")
    private void displayQuantity2(int numberOfCoffees) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view2);

        quantityTextView.setText(  "" +  numberOfCoffees);

    }

    @SuppressLint("SetTextI18n")
    private void displayQuantity3(int numberOfCoffees) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view3);

        quantityTextView.setText(  "" +  numberOfCoffees);

    }

    @SuppressLint("SetTextI18n")
    private void displayQuantity4(int numberOfCoffees) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view4);

        quantityTextView.setText(  "" +  numberOfCoffees);

    }
//         * This method displays the given text on the screen.
//         */
//        private void submitOrder (String message) {
//            TextView orderSummaryTextView =  findViewById(R.id.order_summary_text_view);
//            Intent intent = new Intent(itemRow.this, orderSummary.class);
//            startActivity(intent);
//            orderSummaryTextView.setText(message);
//        }


    //display toast
    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}



