package com.example.bmi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();

        findViews();
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI Formula")
                        .setMessage("Weight(Kg)/(Height(m)^2)")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    private void findViews() {
        // UI Components
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        bHelp = (Button) findViewById(R.id.b_help);
    }

    public void bmi(View v) {
        String bmiStr = getBmiString();
        Log.d("BMI", bmiStr);

        // Use Toast to show message.
        Toast.makeText(this, bmiStr, Toast.LENGTH_LONG).show();

        //產生Builder物件
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //呼叫setMessage方法設定顯示文字
        builder.setMessage(bmiStr);
        //顯示對話框
        builder.show();

        // Use chain invokation to reduce source code.
        // new AlertDialog.Builder(this).setMessage(bmiStr).show();
    }


    public void goResult(View v) {
        String bmiStr = getBmiString();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("BMI_EXTRA", bmiStr);
        startActivity(intent);
    }

    private String getBmiString() {
        //取得元件的值並計算BMI
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        return String.valueOf(bmi);
    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }
}
