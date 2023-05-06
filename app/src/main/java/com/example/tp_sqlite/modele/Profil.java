package com.example.tp_sqlite.modele;

import java.sql.Date;

public class Profil {
    private Date datemesure;
    private Integer poid;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float caloriesConsumed;
    private float caloriesCalculated;
    private String msg;
    public Profil(Integer poid, Integer taille,
                  Integer age, Integer sexe, Integer caloriesConsumed) {
        this.datemesure = new Date(System.currentTimeMillis());
        this.poid = poid;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.caloriesConsumed = caloriesConsumed;
        caloriesCalculation();
    }
    private void caloriesCalculation(){
        float tailleMetre = ((float)taille)/100;
        if(sexe==0)
            this.caloriesCalculated = (float)(10*poid+ (6.25 * tailleMetre)-(5 * (age + 5)));
        else
            this.caloriesCalculated = (float)(10*poid+ (6.25 * tailleMetre)-(5 * (age + 161)));
    }


    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public float getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(float caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public float getCaloriesCalculated() {
        return caloriesCalculated;
    }

    public void setCaloriesCalculated(float caloriesCalculated) {
        this.caloriesCalculated = caloriesCalculated;
    }

    public Date getDatemesure() {
        return datemesure;
    }
}

