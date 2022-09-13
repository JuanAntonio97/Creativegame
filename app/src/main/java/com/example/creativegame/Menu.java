package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void Tanagram(View view){
        Intent i = new Intent(this, Tanagram.class );
        startActivity(i);
    }
    public void detalles(View view){
        Intent i=new Intent(this,Detalles.class);
        startActivity(i);
    }
    public void memory(View view){
        Intent i =new Intent(this,memory.class);
        startActivity(i);
    }
    public void puzzle(View view){
        Intent i =new Intent(this,PuzzleNumero.class);
        startActivity(i);
    }
    public void kardex(View view){
        Intent i =new Intent(this,Adim.class);
        startActivity(i);
    }
}