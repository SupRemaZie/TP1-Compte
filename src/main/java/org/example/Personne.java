package org.example;

import java.util.ArrayList;

public class Personne {

    private String nom;
    private String prenom;

    private String adresse;

    private ArrayList<CompteBancaire> comptes;

    public Personne(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.comptes = new ArrayList<>();
    }


}
