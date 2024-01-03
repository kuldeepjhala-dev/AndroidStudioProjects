package com.example.marksaddition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowMarks extends Activity {

    TextView etShowMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_marks);

        etShowMarks = findViewById(R.id.tv_showMarks);

        Intent i1 = getIntent();
        int marks1 = Integer.parseInt(i1.getStringExtra("marks1"));
        int marks2 = Integer.parseInt(i1.getStringExtra("marks2"));
        int marks3 = Integer.parseInt(i1.getStringExtra("marks3"));

        int totalMarks = marks1 + marks2 + marks3;

        etShowMarks.setText("" + totalMarks);
    }
}