package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button inicio;
    EditText us, pas;
    DBHelper MyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        us=(EditText) findViewById(R.id.use);
        pas=(EditText) findViewById(R.id.pass);
        inicio=(Button)findViewById(R.id.inicioSe);
        MyDB=new DBHelper(this);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String use=us.getText().toString();
                String pass=pas.getText().toString();
                if(use.equals("")||(pass.equals(""))){
                    Toast.makeText(Login.this, "Ingrese el Usuario y/o Contraseña!!", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean result = MyDB.checkaadhar(use);
                    if(result == false){
                        Toast.makeText(Login.this, "El usuario no existe.\n" + " Regístrese", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Register.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getApplicationContext(), Vaccinatorr.class);
                        startActivity(intent);
                    }
                }

            }
        });

    }
}