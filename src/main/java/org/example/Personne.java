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

    public void deposer(double montant, CompteBancaire compte) {
        compte.crediter(montant);
    }

    public void retirer(double montant, CompteBancaire compte) {

        compte.debiter(montant);
    }

    public void ajouterCompte(CompteBancaire compte) {
        this.comptes.add(compte);
    }

    public void supprimerCompte(CompteBancaire compte) {
        this.comptes.remove(compte);
    }

    public ArrayList<CompteBancaire> getComptes() {
        return this.comptes;
    }
    public void faireUnVirement(double montant, CompteBancaire compteDebit, CompteBancaire compteCredit) {
        compteDebit.debiter(montant);
        compteCredit.crediter(montant);
    }









}
