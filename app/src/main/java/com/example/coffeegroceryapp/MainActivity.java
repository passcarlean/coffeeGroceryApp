package com.example.coffeegroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button order1 =  findViewById(R.id.order1);


        // perform click event on the button
        order1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, itemRow.class);
                startActivity(intent);

            }
        });

        Button order2 =  findViewById(R.id.order2);


        // perform click event on the button
        order2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, itemRow.class);
                startActivity(intent);

            }
        });

        Button order3 =  findViewById(R.id.order3);


        // perform click event on the button
        order3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, itemRow.class);
                startActivity(intent);

            }
        });

        Button order4 =  findViewById(R.id.order4);


        // perform click event on the button
        order4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, itemRow.class);
                startActivity(intent);

            }
        });
    }


}
