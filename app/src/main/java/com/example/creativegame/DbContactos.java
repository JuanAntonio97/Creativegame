package com.example.creativegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbContactos extends bHelper {
    Context context;

    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarContacto(String Nombre, String Juego ,String Nivel, String Puntaje) {
        long id = 0;
        try {
            bHelper dbHelper = new bHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre", Nombre);
            values.put("Juego", Juego);
            values.put("Nivel", Nivel);
            values.put("Puntaje", Puntaje);

            id = db.insert(TABLE_ALUMNOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public ArrayList<Contactos> mostrarContactos() {

        bHelper dbHelper = new bHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_ALUMNOS + " ORDER BY Nombre ASC", null);

        if (cursorContactos.moveToFirst()) {
            do {
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setJuego(cursorContactos.getString(2));
                contacto.setNivel(cursorContactos.getString(3));
                contacto.setPuntaje(cursorContactos.getString(4));
                listaContactos.add(contacto);
            } while (cursorContactos.moveToNext());
        }

        cursorContactos.close();

        return listaContactos;
    }
    public Contactos verContacto(int id) {

        bHelper dbHelper = new bHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Contactos contacto = null;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_ALUMNOS + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorContactos.moveToFirst()) {
            contacto = new Contactos();
            contacto.setId(cursorContactos.getInt(0));
            contacto.setNombre(cursorContactos.getString(1));
            contacto.setJuego(cursorContactos.getString(2));
            contacto.setNivel(cursorContactos.getString(3));
            contacto.setPuntaje(cursorContactos.getString(4));
        }

        cursorContactos.close();

        return contacto;
    }
    public boolean editarContacto(int id, String Nombre, String Juego, String Nivel, String Puntaje) {

        boolean correcto = false;

        bHelper dbHelper = new bHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_ALUMNOS + " SET Nombre = '" + Nombre + "', Juego = '" + Juego + "', Nivel = '" + Nivel + "',Puntaje = '" + Puntaje + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
    public boolean eliminarContacto(int id) {

        boolean correcto = false;

        bHelper dbHelper = new bHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_ALUMNOS + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

}
