package com.example.siahapp_evolution.autre;

public class utilisateur {
    String prenom;
    String nom;
    float taille;
    float poids;
    int age;
    String sexe;
    String identifiant;
    String mdp;


    public utilisateur(String prenom, String nom, float taille, float poids, int age, String sexe) {
        this.prenom = prenom;
        this.nom = nom;
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.sexe = sexe;
    }

    public void utilisateur_compte(String identifiant,  String mdp){

        this.identifiant = identifiant;
        this.mdp= mdp;
    }

    public float imc_utilisateur(){
        try{
            float imc = imc = (poids) / (taille*taille) ;
            return imc;
        }
        catch (Exception e ){
            System.out.println("Erreur calcul IMC");
            return 0.0F;
        }
    }


}