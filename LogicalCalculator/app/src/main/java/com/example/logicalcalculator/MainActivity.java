package com.example.logicalcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText etDisplay;
    Button b[] = new Button[19];
    int id[] = {R.id.btAc, R.id.btBack, R.id.btPer, R.id.btDiv,
            R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnMul,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btnSub,
            R.id.btn1, R.id.btn2, R.id.btn3, R.id.btnAdd,
            R.id.btn0, R.id.btnDot, R.id.btnEquals};

    int i, flag = 0;
    String num = "", number = "";
    String range = "0123456789";

    String operation = "", value1 = "", value2 = "" , addTemp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = findViewById(R.id.et);

        for (i = 0; i < b.length; i++) {
            b[i] = findViewById(id[i]);
            b[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button bt = (Button) v;
                    num = bt.getText().toString();

                    if (range.contains(num)) {
                        number = number + num;
                        etDisplay.setText(number);
                    } else if (num.equals("AC")) {
                        etDisplay.setText("0");
                        number = "";
                    } else if (num.equals("back")) {
                        if (number.length() > 0) {
                            number = number.substring(0, number.length() - 1);
                            etDisplay.setText(number);
                        } else {
                            number = "";
                            etDisplay.setText("0");
                        }
                    }

                    if(number.length()>1){
                        if(num.equals("+")  && flag==0){
                            value1 = number;
                            operation = num;
                            flag = 1;
                            number = number + operation;
                            etDisplay.setText(number);
                        }
//                        else if(operation.equals("+") && flag==1){
//
//                        }

                    }

                }
            });

        }


    }
}