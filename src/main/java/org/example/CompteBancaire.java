package org.example;

import java.util.UUID;

public class CompteBancaire {

    private final String numCompte = UUID.randomUUID().toString();
    private final Personne titulaire;
    private double solde;

    private double debitMax = 1000.0;
    private boolean isDecouvert = false;

    private double decouvertMax = 800.0;

    public CompteBancaire( Personne titulaire, double decouvertMax, double debitMax)  {
        this.titulaire = titulaire;
        this.solde = 0;
        this.decouvertMax = decouvertMax;
        this.debitMax = debitMax;
    }


    public void crediter(double montant) {
        if( montant < 0){
            throw new IllegalArgumentException("Depot impossible, montant negatif");
        }
        if (solde >=0 ) {
            this.isDecouvert = false;
        }
        this.solde += montant;

    }

    public void debiter(double montant) {
        if  (montant > this.debitMax) {
            throw new IllegalArgumentException("Retrait impossible, montant superieur au debit max");
        }
        if( montant < 0){
            throw new IllegalArgumentException("Retrait impossible, montant negatif");
        }
        if (solde <0) {
            this.isDecouvert = true;
            System.out.println("Vous êtes à decouvert de " + solde + "€ vous pouvez retirer jusqu'à " + decouvertMax + "€");
        }
       if (this.solde - montant < -this.decouvertMax) {
           throw new IllegalArgumentException("Retrait impossible, decouvert max atteint");
         }

        this.solde -= montant;
    }

    public double getSold() {
        return this.solde;
    }

    public String getTitulaire() {
        return this.titulaire.toString();
    }

    public void setDecouvertMax(double decouvertMax) {
        if(decouvertMax < 0) {
            throw new IllegalArgumentException("Le decouvert max ne peut pas être négatif");
        }
        this.decouvertMax = decouvertMax;
    }
    public double getDecouvertMax() {
        return this.decouvertMax;
    }

    public void setDebitMax(double debitMax) {
        if(debitMax < 0) {
            throw new IllegalArgumentException("Le debit max ne peut pas être négatif");
        }
        this.debitMax = debitMax;
    }
    public double getDebitMax() {
        return this.debitMax;
    }
    /**
     * @return all the informations about the account
     */
    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numCompte=" + numCompte +
                ", titulaire=" + titulaire +
                ", solde=" + solde +
                ", debitMax=" + debitMax +
                ", isDecouvert=" + isDecouvert +
                ", decouvertMax=" + decouvertMax +
                '}';
    }

    public boolean isDecouvert() {
        return this.isDecouvert;
    }

    public void setSold(int i) {
        this.solde = i;
    }
}


