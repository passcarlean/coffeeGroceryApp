package com.example.coffeegroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;



public class orderSummary extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);




        // Get the Intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(EXTRA_MESSAGE);
//
//        // Capture the layout's TextView and set the string as its text
//        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
//
//        orderSummaryTextView.setText(message);
    }



public void shareMessage(View v) {
    final EditText mail =findViewById(R.id.email);
    String address = mail.getText().toString(); //Email address of the receiverString toAddress=address;
    Intent email = new Intent(android.content.Intent.ACTION_SEND);
    email.putExtra(android.content.Intent.EXTRA_EMAIL, address);
    email.putExtra(android.content.Intent.EXTRA_SUBJECT, "This is subject");
    email.setType("plain/text");
    email.putExtra(android.content.Intent.EXTRA_TEXT, "This is the message body.");

    startActivity(email);
//    Intent email = new Intent(Intent.ACTION_SEND);
////need this to prompts email client only
//    email.setType("message/rfc822");
//
//    startActivity(Intent.createChooser(email, "Choose an Email client :"));


////                Intent intent = new Intent(Intent.ACTION_SEND);
////                intent.setData(Uri.parse("mailto:"));//only email apps
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for:" + name);
//                intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//    TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
//    String txt = TextView.getText().toString();
//    String mimeType = "text/plain";
//
//    ShareCompat.IntentBuilder
//            .from(this)
//            .setType(mimeType)
//            .setChooserTitle("Order Summary: ")
//            .setText(txt)
//            .startChooser();
}
}
