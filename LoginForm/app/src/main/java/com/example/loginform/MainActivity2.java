package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvMsg = findViewById(R.id.tvMsg);

        Intent i1 = getIntent();
        String intent_msg = i1.getStringExtra("result");
        tvMsg.setText(intent_msg);

    }
}