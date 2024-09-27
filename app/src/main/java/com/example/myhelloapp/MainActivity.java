package com.example.myhelloapp;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final Button calcBtn = findViewById(R.id.calc);
        final Button bmiCalcBtn = findViewById(R.id.bmiCalc);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);

                // Set a specific calculator package (this example uses Google Calculator)
                intent.setComponent(new ComponentName("com.example.myhelloapp", "com.example.myhelloapp.calculator"));

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Handle the case where the calculator app is not available
                    Log.d("Calculator", "Calculator app not found.");
                }

                Log.d("calc btn click", "onClick: open calc");
            }
        });

        bmiCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);

                intent.setComponent(new ComponentName("com.example.myhelloapp", "com.example.myhelloapp.BmiCalc"));

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Handle the case where the BMI calculator app is not available
                    Log.d("BMI Calculator", "BMI Calculator app not found.");
                }

                Log.d("BMI calc btn click", "onClick: open BMI calc");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}