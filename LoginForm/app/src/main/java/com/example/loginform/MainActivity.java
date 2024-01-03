package com.example.loginform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnLogin, btnSignUp;
    EditText etUser, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        etUser = findViewById(R.id.etUName);
        etPassword = findViewById(R.id.etUPassword);

        String userName = "msu";
        String password = "itm";


        btnLogin.setOnClickListener(v -> {
            String ip_userName = etUser.getText().toString();
            String ip_password = etPassword.getText().toString();

            if ((ip_userName.equals(userName)) && (ip_password.equals(password))) {
                Toast.makeText(getApplicationContext(), "Authorised User", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(getApplicationContext(), MainActivity2.class);
                i1.putExtra("result", "Authorised");
                startActivity(i1);
            } else {
                Toast.makeText(getApplicationContext(), "Unuthorised User", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(getApplicationContext(), MainActivity2.class);
                i1.putExtra("result", "Un-Authorised");
                startActivity(i1);
            }
        });
    }
}