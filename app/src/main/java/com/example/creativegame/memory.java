package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class memory extends AppCompatActivity {
    //los botones del juego
    ImageButton el0, el1, el2, el3, el4, el5, el6, el7, el8, el9, el10, el11;
    //los botones del menú
    Button reiniciar;

    //las imagenes
    int imagenes[];
    //se guardan duplicadas en un array
    ImageButton [] botonera = new ImageButton[12];
    //imagen de fondo;
    int fondo;
    //para barajar
    //el vector que recoge el resultado del "barajamiento"
    ArrayList<Integer> arrayBarajado;
    //COMPARACIÓN
    //los botones que se han pulsado y se comparan
    ImageButton primero;
    //posiciones de las imágenes a comparar en el vector de imágenes
    int numeroPrimero, numeroSegundo;
    //durante un segundo se bloquea el juego y no se puede pulsar ningún botón
    boolean bloqueo = false;

    //para controlar la pausa de un segundo
    final Handler handler = new Handler();

    //finalmente, el número de aciertos y la puntuación
    int aciertos=0;
    int puntuacion=0;
    TextView textoPuntuacion;
    Button btnguardar;
    Button btnmostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        cargarImagenes();
        botonesMenu();
        iniciar();

        btnguardar = (Button)findViewById(R.id.btnGuardar);
        btnmostrar =(Button)findViewById(R.id.btnMostrar);
    }
    public void Guardar(View v){
        //Cadena de Datos
        String Datos = textoPuntuacion.getText().toString();
        SharedPreferences sp = getSharedPreferences("guardado", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        //Existe el archivo
        if(sp.contains("inf")){
            String dg = sp.getString("inf","");
            //Concatena los datos
            dg=dg+"-"+Datos;
            e.putString("inf",dg);
            e.commit();
        }else {
            e.putString("inf",Datos);
            e.commit();
        }
        Toast.makeText(this,"Datos Guardados",Toast.LENGTH_LONG).show();
    }
    public void Mostrar(View v){
        SharedPreferences sp=getSharedPreferences("guardado",Context.MODE_PRIVATE);
        //Existen Datos
        if(sp.contains("inf")){
            //Crear arreglo guardando duplax de datos
            String datos = sp.getString("inf","");
            Intent i=new Intent(this,listaJuego.class);
            i.putExtra("datojuego",datos);
            startActivity(i);
        }else{
            Toast.makeText(this,"No existen datos guardados",Toast.LENGTH_LONG).show();
        }
    }
    public void cargarImagenes() {
        //drawable: Verifica los valores desde la carpeta drawable
        imagenes = new int[]{
                R.drawable.camel,
                R.drawable.coala,
                R.drawable.fox,
                R.drawable.lion,
                R.drawable.monkey,
                R.drawable.wolf,
        };

        fondo = R.drawable.code;
    }
    //
    public ArrayList<Integer> barajar(int longitud) {//Guarda los valores en el array
        ArrayList resultadoA = new ArrayList<Integer>();
        for(int i=0; i<longitud; i++)
            resultadoA.add(i % longitud/2);
        Collections.shuffle(resultadoA);//permuta todos los valores de la lista
        return  resultadoA;
    }

    public void cargarBotones(){
        el0 = (ImageButton) findViewById(R.id.button1);
        botonera[0] = el0;
        el1 = (ImageButton) findViewById(R.id.button2);
        botonera[1] = el1;
        el2 = (ImageButton) findViewById(R.id.button3);
        botonera[2] = el2;
        el3 = (ImageButton) findViewById(R.id.button4);
        botonera[3] = el3;
        el4 = (ImageButton) findViewById(R.id.button5);
        botonera[4] = el4;
        el5 = (ImageButton) findViewById(R.id.button6);
        botonera[5] = el5;
        el6 = (ImageButton) findViewById(R.id.button7);
        botonera[6] = el6;
        el7 = (ImageButton) findViewById(R.id.button8);
        botonera[7] = el7;
        el8 = (ImageButton) findViewById(R.id.button9);
        botonera[8] = el8;
        el9 = (ImageButton) findViewById(R.id.button10);
        botonera[9] = el9;
        el10 = (ImageButton) findViewById(R.id.button11);
        botonera[10] = el10;
        el11 = (ImageButton) findViewById(R.id.button12);
        botonera[11] = el11;
        textoPuntuacion = (TextView)findViewById(R.id.textoPuntuacion);
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }
    public void botonesMenu(){
        reiniciar = (Button) findViewById(R.id.re);

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
    }
    public void comprobar(int i, final ImageButton imgb){
        if(primero==null){//ningún botón ha sido pulsado
            //el botón primero será el que acabamos de pulsar
            primero = imgb;
            /*le asignamos la imagen del vector imágenes situada
            en la posición vectorBarajado[i], que tendrá un valor entre 0 y 7*/
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            primero.setEnabled(false);
            //almacenamos el valor de vectorBarajado[i]
            numeroPrimero=arrayBarajado.get(i);
        }else{//ya hay un botón descubierto
            //bloqueamos todos los demás
            bloqueo=true;
            //el botón segundo será el que acabamos de pulsar
            /*le asignamos la imagen del vector imágenes situada
            en la posición vectorBarajado[i], que tendrá un valor entre 0 y 7*/
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            imgb.setEnabled(false);
            //almacenamos el valor de vectorBarajado[i]
            numeroSegundo=arrayBarajado.get(i);
            //if(primero.getDrawable().getConstantState().equals(imgb.getDrawable().getConstantState())){
            if(numeroPrimero==numeroSegundo){//si coincide el valor los dejamos destapados
                //reiniciamos
                primero=null;
                bloqueo=false;
                //aumentamos los aciertos y la puntuación
                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuación: " + puntuacion);
                //al llegar a8 aciertos se ha ganado el juego
                if(aciertos==8){
                    Toast toast = Toast.makeText(getApplicationContext(), "Has ganado!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{//si NO coincide el valor los volvemos a tapar al cabo de un segundo
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //les ponemos la imagen de fondo
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(R.drawable.code);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(R.drawable.code);
                        //los volvemos a habilitar
                        primero.setEnabled(true);
                        imgb.setEnabled(true);
                        //reiniciamos la variables auxiliaares
                        primero = null;
                        bloqueo = false;
                        //restamos uno a la puntuación
                        if (puntuacion > 0) {
                            puntuacion--;
                            textoPuntuacion.setText("Puntuación: " + puntuacion);
                        }
                    }
                }, 1000);//al cabo de un segundo
            }
        }

    }

    public void iniciar(){
        arrayBarajado = barajar(imagenes.length*2);
        cargarBotones();

        //MOSTRAMOS LA IMAGEN
        for(int i=0; i<botonera.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arrayBarajado.get(i)]);
        }

        //Y EN UN SEGUNDO LA OCULTAMOS
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 1000);

        //AÑADIMOS LOS EVENTOS A LOS BOTONES DEL JUEGO
        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
        aciertos=0;
        puntuacion=0;
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }
    public void Siguiente(View v){
        Intent i = new Intent(memory.this, memoryFrutas.class);
        startActivity(i);
        finish();

    }
}