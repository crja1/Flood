package com.example.flood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.flood.Game;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    SharedPreferences prefs;
    private static final String[] colors = {"1 цвет", "2 цвета", "3 цвета", "4 цвета", "5 цветов", "6 цветов", "7 цветов", "8 цветов", "9 цветов"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_setting);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SettingActivity.this,
                android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case 0:
                Game.colorNumber = 1;
                break;
            case 1:
                Game.colorNumber = 2;
                break;
            case 2:
                Game.colorNumber = 3;
                break;
            case 3:
                Game.colorNumber = 4;
                break;
            case 4:
                Game.colorNumber = 5;
                break;
            case 5:
                Game.colorNumber = 6;
                break;
            case 6:
                Game.colorNumber = 7;
                break;
            case 7:
                Game.colorNumber = 8;
                break;
            case 8:
                Game.colorNumber = 9;
                break;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("colors", Game.colorNumber);
        editor.apply();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
