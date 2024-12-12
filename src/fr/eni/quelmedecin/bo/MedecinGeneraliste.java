package fr.eni.quelmedecin.bo;

import java.time.LocalTime;

import fr.eni.quelmedecin.ctrl.Methode;

/**
 * Classe représentant un médecin généraliste
 */
public class MedecinGeneraliste {
    private String nom;
    private String prenom;
    private String numeroDeTelephone;
    private static int tarif = 25;

    private Creneau[] creneaux;
    private int nbCreneaux;
    private static final int MAX_CRENEAUX = 15;



    private static final Methode methode = Methode.getMethode();

    /**
     * Constructeur
     *
     * @param nom le nom du médecin
     * @param prenom le prénom du médecin
     * @param numeroDeTelephone le numéro de téléphone
     */
    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
        this.nom = nom;
        this.prenom = methode.premiereEnMajuscule(prenom);
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
        this.creneaux = new Creneau[MAX_CRENEAUX];
        this.nbCreneaux = 0;

    }

    public void ajouterCreneau(LocalTime heureDebut, int duree) {
        if (nbCreneaux < MAX_CRENEAUX) {
            new Creneau(heureDebut, duree, this);
        }
    }

    public void ajouterCreneau(Creneau creneau) {
        if (nbCreneaux < MAX_CRENEAUX) {
            creneaux[nbCreneaux++] = creneau;
        }
    }

    
    /**
     * Affiche les informations du médecin
     * @Override
     */
    public void afficher() {
        System.out.printf("%s %s%n", nom.toUpperCase(), prenom);
        System.out.printf("Téléphone : %s%n", numeroDeTelephone);
        System.out.printf("Tarif : %d€%n", tarif);
        System.out.println("Créneaux :");
        for (int i = 0; i < nbCreneaux; i++) {
            creneaux[i].afficher();
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = methode.premiereEnMajuscule(prenom);
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
    }

    public static int getTarif() {
        return tarif;
    }

    public static void setTarif(int tarif) {
        MedecinGeneraliste.tarif = tarif;
    }
}