package fr.eni.quelmedecin.bo;

import fr.eni.quelmedecin.ctrl.Methode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Représente un patient dans le système médical.
 * Gère les informations personnelles et médicales d'un patient.
 * 
 * @author Mariami
 * @version 1.0
 */
public class Patient {
    /** Nom de famille du patient */
    private String nom;    
    /** Prénom du patient */
    private String prenom;    
    /** Numéro de téléphone du patient */
    private String numeroDeTelephone;    
    /** Adresse du patient */
    private Adresse adresse;    
    /** Sexe du patient (F pour féminin, M pour masculin) */
    private char sexe;    
    /** Numéro de sécurité sociale à 15 chiffres */
    private long numeroSecu;    
    /** Date de naissance du patient */
    private LocalDate dateNaissance;    
    /** Commentaires médicaux ou autres remarques */
    private String commentaires;

    /** Instance de l'utilitaire de formatage */
    private static final Methode methode = Methode.getMethode();

    /**
     * Constructeur sans adresse
     * 
     * @param nom Nom du patient
     * @param prenom Prénom du patient
     * @param numeroDeTelephone Numéro de téléphone
     * @param sexe Sexe du patient ('F' ou 'M')
     * @param numeroSecu Numéro de sécurité sociale
     * @param dateNaissance Date de naissance
     * @param commentaires Commentaires éventuels (peut être null)
     */
    public Patient(String nom, String prenom, String numeroDeTelephone, char sexe,
    long numeroSecu, LocalDate dateNaissance, String commentaires) {
    this(nom, prenom, numeroDeTelephone, sexe, numeroSecu, dateNaissance, commentaires, null);
    }

     /**
     * Constructeur complet avec adresse
     * 
     * @param nom Nom du patient
     * @param prenom Prénom du patient
     * @param numeroDeTelephone Numéro de téléphone
     * @param sexe Sexe du patient ('F' ou 'M')
     * @param numeroSecu Numéro de sécurité sociale
     * @param dateNaissance Date de naissance
     * @param commentaires Commentaires éventuels (peut être null)
     * @param adresse Adresse du patient (peut être null)
     */
    public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecu,
            LocalDate dateNaissance, String commentaires, Adresse adresse) {
        this.nom = nom;
        this.prenom = methode.premiereEnMajuscule(prenom);
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
        this.sexe = sexe;
        this.numeroSecu = numeroSecu;
        this.dateNaissance = dateNaissance;
        this.commentaires = commentaires;        
        this.adresse = adresse;
    }
    
     /**
     * Affiche les informations complètes du patient
     * Format d'affichage :
     * - Nom et prénom
     * - Téléphone
     * - Sexe
     * - Numéro de sécurité sociale
     * - Date de naissance
     * - Commentaires
     * - Adresse (si renseignée)
     */
    public void afficher() {
        // Informations personnelles
        System.out.printf("%s %s%n", nom.toUpperCase(), prenom);
        System.out.printf("Téléphone : %s%n", numeroDeTelephone);
        System.out.printf("Sexe : %s%n", sexe == 'F' ? "Féminin" : "Masculin");
        System.out.printf("Numéro de Sécurité sociale : %d%n", numeroSecu);
        // Formatage et affichage de la date de naissance
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH);
        System.out.printf("Date de naissance : %s%n", dateNaissance.format(formatter));
        // Affichage des commentaires
        System.out.printf("Commentaires : %s%n",
            (commentaires == null || commentaires.isEmpty()) ? "[aucun commentaire]" : commentaires);
        // Affichage de l'adresse si elle existe
        if (adresse != null) {
                adresse.afficher();
            }
        }
	
    // Getters and Setters

    /**
     * Récupère le nom du patient
     * @return Le nom de famille du patient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du patient
     * @param nom Le nouveau nom de famille à attribuer
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le prénom du patient
     * @return Le prénom du patient
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom du patient
     * Le prénom sera formaté avec la première lettre en majuscule
     * @param prenom Le nouveau prénom à attribuer
     */
    public void setPrenom(String prenom) {
        this.prenom = methode.premiereEnMajuscule(prenom);
    }

    /**
     * Récupère le numéro de téléphone du patient
     * @return Le numéro de téléphone formaté
     */
    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    /**
     * Modifie le numéro de téléphone du patient
     * Le numéro sera automatiquement formaté selon le format standard
     * @param numeroDeTelephone Le nouveau numéro de téléphone
     */
    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
    }

    /**
     * Récupère l'adresse du patient
     * @return L'adresse complète du patient
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Modifie l'adresse du patient
     * @param adresse La nouvelle adresse du patient
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Récupère le sexe du patient
     * @return Le sexe du patient ('F' pour féminin, 'M' pour masculin)
     */
    public char getSexe() {
        return sexe;
    }

    /**
     * Modifie le sexe du patient
     * @param sexe Le nouveau sexe ('F' pour féminin, 'M' pour masculin)
     */
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    /**
     * Récupère le numéro de sécurité sociale du patient
     * @return Le numéro de sécurité sociale à 15 chiffres
     */
    public long getNumeroSecu() {
        return numeroSecu;
    }

    /**
     * Modifie le numéro de sécurité sociale du patient
     * @param numeroSecu Le nouveau numéro de sécurité sociale à 15 chiffres
     */
    public void setNumeroSecu(long numeroSecu) {
        this.numeroSecu = numeroSecu;
    }

    /**
     * Récupère la date de naissance du patient
     * @return La date de naissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Modifie la date de naissance du patient
     * @param dateNaissance La nouvelle date de naissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Récupère les commentaires associés au patient
     * @return Les commentaires ou null si aucun commentaire n'existe
     */
    public String getCommentaires() {
        return commentaires;
    }

    /**
     * Modifie les commentaires associés au patient
     * @param commentaires Les nouveaux commentaires (peut être null)
     */
    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}