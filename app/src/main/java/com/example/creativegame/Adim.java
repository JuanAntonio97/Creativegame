package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Adim extends AppCompatActivity {
    Button ini,salir;
    EditText ad,pas;
    private int cont=5;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim);
        ad= (EditText) findViewById(R.id.ud);
        pas=(EditText) findViewById(R.id.pa);
        ini=(Button) findViewById(R.id.in);
        info=(TextView)findViewById(R.id.inf);
        salir=(Button) findViewById(R.id.reg);
        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validar(ad.getText().toString(),pas.getText().toString());
            }
        });

    }
    public void Validar(String usuario, String contraseña){
        if((usuario.equals("admin")) && (contraseña.equals("1234"))){
            Intent intent = new Intent (Adim.this, Kardex.class);
            startActivity(intent);
        }else{
            cont--;
            info.setText("Número de intentos restantes:"+String.valueOf(cont));
            if(cont==0){
                ini.setEnabled(false);
            }
        }
    }
    public void salir(View view){
        Intent i = new Intent(Adim.this, Menu.class);
        startActivity(i);
        finish();
    }
}