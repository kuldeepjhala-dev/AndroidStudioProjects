package com.kuldeep.citydirectory;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Settings extends AppCompatActivity {
    ActionBar actionBar;
    TextView english, french, arabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        loadLocale();
        TextView select_language_id = findViewById(R.id.select_language_id);
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FFFFFF"));
        actionBar.setBackgroundDrawable(colorDrawable);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_language);

        english = dialog.findViewById(R.id.tv_english);
        french = dialog.findViewById(R.id.tv_french);
        arabic = dialog.findViewById(R.id.tv_arabic);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_language_id.setText(english.getText());
                setLocale("en");
                dialog.dismiss();
                recreate();
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_language_id.setText(french.getText());
                setLocale("fr");
                dialog.dismiss();
                recreate();

            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_language_id.setText(arabic.getText());
                setLocale("ar");
                dialog.dismiss();
                recreate();
            }
        });

        select_language_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.create();
                dialog.show();
            }
        });
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("app_lang", language);
        editor.apply();
    }

    private void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        String language = preferences.getString("app_lang", "");
        setLocale(language);
    }
}