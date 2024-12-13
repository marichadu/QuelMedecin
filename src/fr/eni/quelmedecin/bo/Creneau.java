package fr.eni.quelmedecin.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 * Représente un créneau horaire de consultation médicale.
 * Chaque créneau est caractérisé par une heure de début, une durée,
 * et est associé à un médecin généraliste.
 * 
 * @author Mariami
 * @version 1.0
 */
public class Creneau {
     /** Heure de début du créneau */
     private LocalTime heureDebut;
    
     /** Durée du créneau en minutes */
     private int duree;
     
     /** Médecin associé à ce créneau */
     private MedecinGeneraliste medecin;

     /**
     * Constructeur d'un créneau de consultation
     * Crée un nouveau créneau et l'associe automatiquement au médecin
     * 
     * @param heureDebut Heure de début de la consultation
     * @param duree Durée en minutes
     * @param medecin Médecin généraliste associé
     */ 
    public Creneau(LocalTime heureDebut, int duree, MedecinGeneraliste medecin) {
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.medecin = medecin;
        medecin.ajouterCreneau(this);
    }

    /**
     * Affiche les informations du créneau
     * Format d'affichage : HH:mm - HH:mm (durée minutes)
     * Exemple : 09:00 - 09:15 (15 minutes)
     */
    public void afficher() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime heureFin = heureDebut.plusMinutes(duree);
        System.out.printf("%s - %s (%d minutes)%n", 
            heureDebut.format(fmt),
            heureFin.format(fmt),
            duree);
    }
    
    // Getters

    /**
    * Récupère le médecin associé au créneau
    * @return Le médecin généraliste responsable de ce créneau
    */
    public MedecinGeneraliste getMedecin() {
        return medecin;
    }

    /**
     * Récupère l'heure de début du créneau
     * @return L'heure de début de la consultation
     */
    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    /**
     * Récupère la durée du créneau
     * @return La durée en minutes
     */
    public int getDuree() {
        return duree;
    }
}