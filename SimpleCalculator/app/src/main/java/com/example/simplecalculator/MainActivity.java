package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText et1, et2;
    Button btSub, btAdd, btMul, btDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.etN1);
        et2=findViewById(R.id.etN2);
        btAdd=findViewById(R.id.btnAdd);
        btSub=findViewById(R.id.btnSub);
        btMul=findViewById(R.id.btnMul);
        btDiv=findViewById(R.id.btnDiv);

        btAdd.setOnClickListener(v -> {
            int no1 = Integer.parseInt(et1.getText().toString());
            int no2 = Integer.parseInt(et2.getText().toString());
            Toast.makeText(getApplicationContext(),""+(no1+no2), Toast.LENGTH_LONG).show();
        });

        btSub.setOnClickListener(v -> {
            int no1 = Integer.parseInt(et1.getText().toString());
            int no2 = Integer.parseInt(et2.getText().toString());
            Toast.makeText(getApplicationContext(),no1-no2, Toast.LENGTH_LONG).show();
        });

        btMul.setOnClickListener(v -> {
            int no1 = Integer.parseInt(et1.getText().toString());
            int no2 = Integer.parseInt(et2.getText().toString());
            Toast.makeText(getApplicationContext(),no1*no2, Toast.LENGTH_LONG).show();
        });

        btDiv.setOnClickListener(v -> {
            int no1 = Integer.parseInt(et1.getText().toString());
            int no2 = Integer.parseInt(et2.getText().toString());
            Toast.makeText(getApplicationContext(),no1/no2, Toast.LENGTH_LONG).show();
        });

    }
}