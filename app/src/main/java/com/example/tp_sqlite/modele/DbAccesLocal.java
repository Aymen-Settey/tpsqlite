package com.example.tp_sqlite.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_sqlite.outils.MySQLiteOpenHelper;

import java.util.Date;

public class DbAccesLocal {
    private final String nomBase ="dbCalories.sqlite";
    private Integer versionBase=1;
    private MySQLiteOpenHelper accessDB;
    private SQLiteDatabase db;
    public DbAccesLocal(Context context){
        accessDB = new MySQLiteOpenHelper(context, nomBase , null , versionBase);
    }
    /**
     * ajout d'un profil dans la base de donnée
     * @param profil
     */
    public void ajout(Profil profil){
        db = accessDB.getWritableDatabase();
        String req = "insert into profil (poid,taille,age,sexe, calories)values";
        req += "("+profil.getPoid()
                +","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+","+profil.getCaloriesConsumed()+")";
        db.execSQL(req);
    }
    /**
     * récupérer la liste des profils de la BD et de récupérer la dernière ligne
     * @return
     */
    public Profil recupDernier()
    {
        db = accessDB.getReadableDatabase();
        Profil profil=null;
        String req = "select * from profil";
        Cursor curseur = db.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast())
        {

            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            Integer calories = curseur.getInt(5);
            profil = new Profil(poids, taille, age, sexe, calories);
        }
        curseur.close();
        return profil;
    }

}
