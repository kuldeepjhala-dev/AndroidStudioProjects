package com.example.findpower;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Math;

public class MainActivity extends Activity {

    Button btnCalculate;
    EditText etNumber, etPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalc);
        etNumber = findViewById(R.id.etInput1);
        etPower = findViewById(R.id.etInput2);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number = Double.parseDouble(etNumber.getText().toString());
                double power =  Double.parseDouble(etPower.getText().toString());
                double ans = Math.pow(number, power);
                Toast.makeText(getApplicationContext(), "Power of " + number + " is " + ans ,Toast.LENGTH_LONG).show();
            }
        });
    }
}