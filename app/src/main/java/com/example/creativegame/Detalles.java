package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
    }
    public void Regresar(View v){
        Intent i = new Intent(Detalles.this, Menu.class);
        startActivity(i);
        finish();

    }
}