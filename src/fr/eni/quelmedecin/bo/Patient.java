package fr.eni.quelmedecin.bo;

import fr.eni.quelmedecin.ctrl.Methode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Patient {
    private String nom;
    private String prenom;
    private String numeroDeTelephone;
    private char sexe;
    private long numeroSecu;
    private LocalDate dateNaissance;
    private String commentaires;

    private static final Methode methode = Methode.getMethode();

    public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecu,
            LocalDate dateNaissance, String commentaires) {
        this.nom = nom;
        this.prenom = methode.premiereEnMajuscule(prenom);
        this.numeroDeTelephone = methode.formatNumeroTelephone(numeroDeTelephone);
        this.sexe = sexe;
        this.numeroSecu = numeroSecu;
        this.dateNaissance = dateNaissance;
        this.commentaires = commentaires;
    }

    public void afficher() {
        System.out.printf("%s %s%n", nom.toUpperCase(), prenom);
        System.out.printf("Téléphone : %s%n", numeroDeTelephone);
        System.out.printf("Sexe : %s%n", sexe == 'F' ? "Féminin" : "Masculin");
        System.out.printf("Numéro de Sécurité sociale : %d%n", numeroSecu);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH);
        System.out.printf("Date de naissance : %s%n", dateNaissance.format(formatter));
        
        System.out.printf("Commentaires : %s%n",
            (commentaires == null || commentaires.isEmpty()) ? "[aucun commentaire]" : commentaires);
    }
	
    // Getters and Setters
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

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public long getNumeroSecu() {
        return numeroSecu;
    }

    public void setNumeroSecu(long numeroSecu) {
        this.numeroSecu = numeroSecu;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}
