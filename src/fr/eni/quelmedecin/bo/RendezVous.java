package fr.eni.quelmedecin.bo;

import java.time.LocalDate;

public class RendezVous {
    private Creneau creneau;
    private Patient patient;
    private LocalDate date;

    public RendezVous(Creneau creneau, Patient patient, LocalDate date) {
        this.creneau = creneau;
        this.patient = patient;
        this.date = date;
    }

    public void afficher() {
        System.out.printf("Rendez-vous du %d %s %d ", 
            date.getDayOfMonth(),
            date.getMonth().toString().toLowerCase(),
            date.getYear());
            
        // Display time slot
        creneau.afficher();
        
        System.out.println("avec le Dr " + creneau.getMedecin().getNom());
        System.out.println("pour ");
        patient.afficher();
    }

    // Getters and setters
    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}