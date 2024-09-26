package com.example.myhelloapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        final Button add_button = findViewById(R.id.add_button);
        final Button sub_button = findViewById(R.id.sub_button);
        final Button division_button  = findViewById(R.id.division_button);
        final Button multiply_button = findViewById(R.id.multiply_button);
        final Button reset = findViewById(R.id.reset);

        final EditText inpt1 = findViewById(R.id.inpt1);
        final EditText inpt2 = findViewById(R.id.inpt2);
        final EditText inpt3 = findViewById(R.id.inpt3);

        sub_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Log.d("Input 1", "Input 1 = " + inpt1.getText());
                Log.d("Input 2", "Input 2 = " + inpt2.getText());

                double subtract = Double.parseDouble(inpt1.getText().toString()) - Double.parseDouble(inpt2.getText().toString());

                Log.d("SUBTRACT", "" + subtract);
                inpt3.setText(String.valueOf(subtract));
            }
        });

        division_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Log.d("Input 1", "Input 1 = " + inpt1.getText());
                Log.d("Input 2", "Input 2 = " + inpt2.getText());

                double division = Double.parseDouble(inpt1.getText().toString()) / Double.parseDouble(inpt2.getText().toString());

                Log.d("DIVISION", "" + division);
                inpt3.setText(String.valueOf(division));
            }
        });

        multiply_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Log.d("Input 1", "Input 1 = " + inpt1.getText());
                Log.d("Input 2", "Input 2 = " + inpt2.getText());

                double multiply = Double.parseDouble(inpt1.getText().toString()) * Double.parseDouble(inpt2.getText().toString());

                Log.d("SUM", "" + multiply);
                inpt3.setText(String.valueOf(multiply));
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Log.d("Input 1", "Input 1 = " + inpt1.getText());
                Log.d("Input 2", "Input 2 = " + inpt2.getText());

                double sum = Double.parseDouble(inpt1.getText().toString()) + Double.parseDouble(inpt2.getText().toString());

                Log.d("SUM", "" + sum);
                inpt3.setText(String.valueOf(sum));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inpt1.setText("");
                inpt2.setText("");
                inpt3.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}