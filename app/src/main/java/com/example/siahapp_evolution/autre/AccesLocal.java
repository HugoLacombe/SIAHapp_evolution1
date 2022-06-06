package com.example.siahapp_evolution.autre;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AccesLocal {

    //propriétés
    private String nomBase ="bdSIAH.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase BDD;

    /**
     * Constructor
     * @param context
     */
    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context, nomBase, null, versionBase);
    }

    /**
     * Ajout d'un profil dans la bdd
     * @param util
     */
    public void ajout(utilisateur util){
        BDD = accesBD.getWritableDatabase();
        String req = "insert into utilisateur (identifiant, prenom, nom, poids, taille, age, sexe) values";
             req+= "(\""+util.identifiant+"\",\""+util.prenom+"\",\""+util.nom+"\","+util.poids+","+util.taille+","+util.age+","+util.sexe+")";
        BDD.execSQL(req);

    }

    /**
     * Récupère le dernier utilisateur enregistrée
     * @return
     */

    public utilisateur recupDernier(){
        BDD = accesBD.getReadableDatabase();
        utilisateur util = null;
        String req = "select * from utilisateur";
        Cursor curseur = BDD.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            String id = curseur.getString(0);
            String prenom = curseur.getString(1);
            String nom = curseur.getString(2);
            Float poids = curseur.getFloat(3);
            Float taille = curseur.getFloat(4);
            Integer age = curseur.getInt(5);
            Integer sexe = curseur.getInt(6);
            util = new utilisateur(id,prenom,nom,poids,taille,age, sexe);
        }
        curseur.close();
        return util;
    }

}
