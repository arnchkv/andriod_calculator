package com.example.myhelloapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BmiCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi_calc);

        final Button calcBmi = findViewById(R.id.calcBmi);
        final EditText personWeight = findViewById(R.id.personWeight);
        final EditText personHeight = findViewById(R.id.personHeight);
        final TextView bmiResult = findViewById(R.id.bmiResult);

        calcBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final double personWeightInput = Double.parseDouble(personWeight.getText().toString());
                final double personHeightInput = Double.parseDouble(personHeight.getText().toString());

                final double resultBmi = personWeightInput / personHeightInput * 100;

                Log.d("result", "onClick: resultBmi = " + resultBmi);

                bmiResult.setText(String.valueOf(resultBmi));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}