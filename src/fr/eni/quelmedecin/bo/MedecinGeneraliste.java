package fr.eni.quelmedecin.bo;

import fr.eni.quelmedecin.ctrl.Methode;


/**
 * Représente un médecin généraliste dans le système.
 * Gère les informations personnelles et les créneaux de consultation.
 * @author Mariami
 * @version 1.0
 */
public class MedecinGeneraliste {
    private String nom;     /** Nom de famille du médecin */
    private String prenom;    /** Prénom du médecin */
    private String numeroDeTelephone; /** Numéro de téléphone du cabinet */
    private static int tarif = 25; /** Tarif de consultation en euros */

    private Adresse adresse; /** Adresse du cabinet médical */
    private Creneau[] creneaux; /** Tableau des créneaux de consultation disponibles */
    private int nbCreneaux; /** Nombre actuel de créneaux enregistrés */
    private static final int MAX_CRENEAUX = 15; /** Nombre maximum de créneaux autorisés par médecin */
    
    /** Instance de l'utilitaire de formatage */
    private static final Methode methode = Methode.getMethode();

    /**
     * Constructeur simplifié sans adresse
     * 
     * @param nom Nom du médecin
     * @param prenom Prénom du médecin
     * @param numeroDeTelephone Numéro de téléphone du cabinet
     */
    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
        this(nom, prenom, numeroDeTelephone, null);
    }
    
    /**
     * Constructeur complet avec adresse
     * 
     * @param nom Nom du médecin
     * @param prenom Prénom du médecin
     * @param numeroDeTelephone Numéro de téléphone du cabinet
     * @param adresse Adresse du cabinet (peut être null)
     */
    public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
        this.nom = nom;
        this.prenom = methode.premiereEnMajuscule(prenom);
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
        this.adresse = adresse;
        this.creneaux = new Creneau[MAX_CRENEAUX];
        this.nbCreneaux = 0;

    }
    /**
     * Ajoute un nouveau créneau de consultation à l'emploi du temps du médecin.
     * L'ajout est limité par MAX_CRENEAUX.
     * 
     * @param creneau Le créneau à ajouter
     * @throws IllegalStateException si le nombre maximum de créneaux est atteint
     */
    void ajouterCreneau(Creneau creneau) {
        if (nbCreneaux < MAX_CRENEAUX) {
            creneaux[nbCreneaux++] = creneau;
        } else {
            throw new IllegalStateException("Nombre maximum de créneaux atteint");
        }
    }

     /**
     * Affiche les informations complètes du médecin :
     * - Nom et prénom
     * - Numéro de téléphone
     * - Tarif de consultation
     * - Adresse (si renseignée)
     * - Liste des créneaux disponibles
     */
    public void afficher() {
        System.out.printf("%s %s%n", nom.toUpperCase(), prenom);
        System.out.printf("Téléphone : %s%n", numeroDeTelephone);
        System.out.printf("Tarif : %d€%n", tarif);
        if (adresse != null) {
            System.out.println("Adresse :");
            adresse.afficher();
        }
        System.out.println("Créneaux :");
        for (int i = 0; i < nbCreneaux; i++) {
            creneaux[i].afficher();
        }
    }

     // Getters et Setters avec documentation
    
     /**
     * Récupère le nom du médecin
     * @return Le nom du médecin
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du médecin
     * @param nom Le nouveau nom à attribuer
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le prénom du médecin
     * @return Le prénom du médecin
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom du médecin
     * Le prénom sera formaté avec la première lettre en majuscule
     * @param prenom Le nouveau prénom à attribuer
     */
    public void setPrenom(String prenom) {
        this.prenom = methode.premiereEnMajuscule(prenom);
    }

    /**
     * Récupère le numéro de téléphone du cabinet
     * @return Le numéro de téléphone formaté
     */
    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    /**
     * Modifie le numéro de téléphone
     * Le numéro sera automatiquement formaté selon le format standard
     * @param numeroDeTelephone Le nouveau numéro de téléphone
     */
    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
    }

    /**
     * Récupère l'adresse du cabinet
     * @return L'adresse du cabinet médical
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Modifie l'adresse du cabinet
     * @param adresse La nouvelle adresse du cabinet
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Récupère le tarif de consultation
     * @return Le tarif en euros
     */
    public static int getTarif() {
        return tarif;
    }

    /**
     * Modifie le tarif de consultation
     * @param tarif Le nouveau tarif en euros
     */
    public static void setTarif(int tarif) {
        MedecinGeneraliste.tarif = tarif;
    }
}