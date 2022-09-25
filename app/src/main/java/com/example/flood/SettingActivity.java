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
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    SharedPreferences prefs;
    private static final String[] colors = {"3", "4", "5", "6", "7", "8", "9"};
    private static final String[] moves = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    private static final String[] ns = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE);
        prefs = getSharedPreferences("moves", Context.MODE_PRIVATE);
        prefs = getSharedPreferences("ns", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_setting);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(SettingActivity.this,
                android.R.layout.simple_spinner_item, colors);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SettingActivity.this,
                android.R.layout.simple_spinner_item, moves);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SettingActivity.this,
                android.R.layout.simple_spinner_item, ns);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner1.post(new Runnable() {
            @Override
            public void run() {
                spinner1.setSelection(Game.colorNumber - 3);
            }
        });
        spinner2.post(new Runnable() {
            @Override
            public void run() {
                spinner2.setSelection(Game.moveNumber - 1);
            }
        });
        spinner3.post(new Runnable() {
            @Override
            public void run() {
                spinner3.setSelection(Game.n - 1);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (parent == spinner1) {
            Game.colorNumber = position + 3;
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("colors", Game.colorNumber);
            editor.apply();
        }
        if (parent == spinner2) {
            Game.moveNumber = position + 1;
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("moves", Game.moveNumber);
            editor.apply();
        }
        if (parent == spinner3) {
            Game.n = position + 1;
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("ns", Game.n);
            editor.apply();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
