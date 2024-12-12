package fr.eni.quelmedecin.bo;

import java.time.LocalTime;

public class Creneau {
    private LocalTime heureDebut;
    private int duree;
    private MedecinGeneraliste medecin;

    public Creneau(LocalTime heureDebut, int duree, MedecinGeneraliste medecin) {
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.medecin = medecin;
        medecin.ajouterCreneau(this); // Bidirectional association
    }

    public void afficher() {
        LocalTime heureFin = heureDebut.plusMinutes(duree);
        System.out.printf("%02d:%02d - %02d:%02d (%d minutes)\n",
            heureDebut.getHour(), heureDebut.getMinute(),
            heureFin.getHour(), heureFin.getMinute(),
            duree);
        System.out.println("Médecin associé à ce créneau : Dr " + medecin.getNom());
    }

    // Getters and setters
    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public int getDuree() {
        return duree;
    }

    public MedecinGeneraliste getMedecin() {
        return medecin;
    }
}