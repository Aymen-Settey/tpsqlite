package com.example.tp_sqlite.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    //Propriété
    private String creation = "create table profil ("
            + "datemesure TEXT PRIMARY KEY ,"
            + "poid INTEGER NOT NULL,"
            + "taille INTEGER NOT NULL,"
            + "age INTEGER NOT NULL,"
            + "sexe INTEGER NOT NULL,"
            + "calories INTEGER NOT NULL);";
    /**
     * Constructeur
     * @param context
     * @param name le nom de la BD
     * @param factory
     * @param version la version de la BD
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name,
                              @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(creation); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

