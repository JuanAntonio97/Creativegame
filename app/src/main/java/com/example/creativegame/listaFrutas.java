package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listaFrutas extends AppCompatActivity {
    private ListView lvf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frutas);
        lvf=(ListView)findViewById(R.id.lvf);
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
        lvf.setAdapter(adapter);
    }
}