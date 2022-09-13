package com.example.creativegame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class bHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "kardex.db";
    public static final String TABLE_ALUMNOS = "t_alumnos";

    public bHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ALUMNOS+ "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT NOT NULL,"+
                "Juego TEXT NOT NULL," +
                "Nivel TEXT NOT NULL," +
                "Puntaje TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ALUMNOS);
        onCreate(sqLiteDatabase);
    }
}
