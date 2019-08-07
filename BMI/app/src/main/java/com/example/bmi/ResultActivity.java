package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        float bmi = intent.getFloatExtra("BMI_EXTRA", 0);

        TextView result = (TextView) findViewById(R.id.resultTextView);
        result.setText("Your BMI is "+bmi);
    }
}
