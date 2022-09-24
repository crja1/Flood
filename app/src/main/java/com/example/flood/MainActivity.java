package com.example.flood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("settings", Context.MODE_PRIVATE);
        Game.colorNumber = prefs.getInt("colors", 9);
        Game.moveNumber = prefs.getInt("moves", 16);
        Game.n = prefs.getInt("ns", 6);
        setContentView(R.layout.activity_main);
        final Button b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(i);
            }
        });
        final Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RuleActivity.class);
                startActivity(i);
            }
        });
        final Button b3 = (Button)findViewById(R.id.button3);
        b3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(i);
            }
        });
    }
}