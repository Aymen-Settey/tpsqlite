package com.example.tp_sqlite.controler;

import android.content.Context;

import com.example.tp_sqlite.modele.DbAccesLocal;
import com.example.tp_sqlite.modele.Profil;


public class mainActivityControler {
    private static mainActivityControler instance=null;
    private static DbAccesLocal accesLocal;
    private static Profil profil;
    public mainActivityControler() {
        super();
    }
    public static mainActivityControler getInstance(Context context){
        if(mainActivityControler.instance==null){
            mainActivityControler.instance= new mainActivityControler();
            accesLocal= new DbAccesLocal(context);
            profil = accesLocal.recupDernier();
        }
        return mainActivityControler.instance;
    }
    public void createProfil(Integer poids , Integer taille, Integer age,
                             Integer sexe, Integer calorieConsumed){

        profil = new Profil(poids , taille , age , sexe, calorieConsumed );
        accesLocal.ajout(profil);
    }
    
    public float getcalories(){
        return profil.getCaloriesCalculated();
    }
    public Integer getPoid(){
        if(profil == null){ return null; }
        else { return profil.getPoid(); }
    }
    public Integer getTaille(){
        if(profil == null){ return null;}
        else { return profil.getTaille(); }
    }
    public Integer getAge(){
        if(profil == null){ return null;}
        else { return profil.getAge(); }
    }
    public Integer getSexe(){
        if(profil == null){ return null;}
        else { return profil.getSexe(); }
    }
    public Object getCalorieConsumed(){
        if(profil == null){ return null;}
        else { return profil.getCaloriesConsumed();}
    }
}
