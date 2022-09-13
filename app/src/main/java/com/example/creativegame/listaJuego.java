package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listaJuego extends AppCompatActivity {
    private ListView lv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_juego);
        lv3=(ListView)findViewById(R.id.lv3);
        Bundle sp = getIntent().getExtras();
        String[] dg = sp.getString("datojuego").split("-");
        int numDatos = dg.length;
        String[] items = new String[numDatos];
        //Acceder a cada dato
        for(int i=0;i<numDatos;i++){
            String[]d=dg[i].split(";");
            items[i]="Puntuacion Final:"  +d[0];

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        lv3.setAdapter(adapter);
    }
}