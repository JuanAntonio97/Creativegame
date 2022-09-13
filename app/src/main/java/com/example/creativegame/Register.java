package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name, user, pass, repass;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button register,alredy;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=(EditText) findViewById(R.id.nom);
        user=(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.pass);
        repass=(EditText) findViewById(R.id.repass);
        alredy=(Button)findViewById(R.id.alredy);
        register=(Button) findViewById(R.id.register);
        radioGroup =findViewById(R.id.rG);
        MyDB=new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee = name.getText().toString();
                String userr = user.getText().toString();
                String pasw = pass.getText().toString();
                String rep = repass.getText().toString();

                if (namee.equals("") || userr.equals("") || pasw.equals("") || rep.equals("")) {
                    Toast.makeText(Register.this, "Llena todos los campos!!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = MyDB.checkaadhar(userr);
                    if (result == false) {
                        Boolean res = MyDB.insertData(namee, userr, pasw, rep);
                        if (res == true) {
                            Toast.makeText(Register.this, "¡Registro exitoso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this, "¡Registro fallido!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        alredy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Toast.makeText(Register.this, "El usuario ya existe.\\n Inicie sesión", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
            }
        });
    }
    public void  checkButton(View v){
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
        Toast.makeText(this,"Seleccionar Opcion: "+radioButton.getText(),Toast.LENGTH_SHORT).show();

    }
}