package fr.eni.quelmedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Représente un rendez-vous médical.
 * Associe un patient à un créneau horaire d'un médecin pour une date donnée.
 * 
 * @author Mariami
 * @version 1.0
 */
public class RendezVous {
    /** Créneau horaire du rendez-vous */
    private Creneau creneau;
        /** Patient concerné par le rendez-vous */
    private Patient patient;
        /** Date du rendez-vous */
    private LocalDate date;

     /**
     * Constructeur d'un rendez-vous médical
     * 
     * @param creneau Créneau horaire choisi
     * @param patient Patient concerné par le rendez-vous
     * @param date Date du rendez-vous
     */
    public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
        this.creneau = creneau;
        this.patient = patient;
        this.date = date;
    }

    /**
     * Affiche les informations complètes du rendez-vous
     * Format d'affichage :
     * - Date du rendez-vous
     * - Horaires du créneau
     * - Nom du médecin
     * - Informations du patient
     */
    public void afficher() {
        // Formatage de la date en français
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH);
        System.out.printf("Rendez-vous du %s ", date.format(formatter));
        
        // Affichage des horaires
        creneau.afficher();
        // Affichage du médecin
        System.out.println("avec le Dr " + creneau.getMedecin().getNom());
        // Affichage des informations du patient
        System.out.println("pour ");
        patient.afficher();
    }

    // Getters and setters

    /**
     * Récupère le créneau horaire du rendez-vous
     * @return Le créneau horaire associé
     */
    public Creneau getCreneau() {
        return creneau;
    }

    /**
     * Modifie le créneau horaire du rendez-vous
     * @param creneau Le nouveau créneau horaire
     */
    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    /**
     * Récupère le patient concerné par le rendez-vous
     * @return Le patient associé au rendez-vous
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Modifie le patient du rendez-vous
     * @param patient Le nouveau patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Récupère la date du rendez-vous
     * @return La date du rendez-vous
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Modifie la date du rendez-vous
     * @param date La nouvelle date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}