package com.example.marksaddition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText etMarks1, etMarks2, etMarks3;
    Button btnAddMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMarks1 = findViewById(R.id.etOne);
        etMarks2 = findViewById(R.id.etTwo);
        etMarks3 = findViewById(R.id.etThree);
        btnAddMarks = findViewById(R.id.btnMarks);


        btnAddMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int marks1 = Integer.parseInt(etMarks1.getText().toString());
                int marks2 = Integer.parseInt(etMarks2.getText().toString());
                int marks3 = Integer.parseInt(etMarks3.getText().toString());

                Intent i1 = new Intent(getApplicationContext(), ShowMarks.class);
                i1.putExtra("marks1", ""+marks1);
                i1.putExtra("marks2", ""+marks2);
                i1.putExtra("marks3", ""+marks3);

                startActivity(i1);

            }
        });

    }
}