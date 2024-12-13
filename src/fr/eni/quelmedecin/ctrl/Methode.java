package fr.eni.quelmedecin.ctrl;

/**
 * Classe utilitaire pour le formatage des données.
 * Implémente le pattern Singleton pour assurer une instance unique.
 * Fournit des méthodes de formatage pour les noms et numéros de téléphone.
 * 
 * @author Mariami
 * @version 1.0
 */
public class Methode {
    /** Instance unique de la classe (pattern Singleton) */
    private static final Methode instance = new Methode();
    
    /** Message d'erreur standard pour un numéro de téléphone incorrect */
    private static final String NUMERO_INCORRECT = "<< numero incorrect >>";
    
    /**
     * Constructeur privé pour empêcher l'instanciation directe
     * (pattern Singleton)
     */
    private Methode() {}
    
    /**
     * Récupère l'instance unique de la classe
     * @return L'instance unique de Methode
     */
    public static Methode getMethode() {
        return instance;
    }
    
    /**
     * Met en majuscule la première lettre de chaque mot d'une chaîne.
     * Gère les séparateurs espace, tiret et apostrophe.
     * 
     * @param str La chaîne à formater
     * @return La chaîne avec les premières lettres en majuscule, ou la chaîne
     *         originale si null ou vide
     */
    public String premiereEnMajuscule(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        // Séparation sur les espaces, tirets et apostrophes
        String[] parts = str.split("[ '-]");
        StringBuilder result = new StringBuilder();
        
        // Traitement de chaque partie
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                // Première lettre en majuscule, reste en minuscule
                result.append(parts[i].substring(0, 1).toUpperCase())
                      .append(parts[i].substring(1).toLowerCase());
            }
            // Réinsertion du séparateur d'origine
            if (i < parts.length - 1) {
                result.append(str.charAt(str.indexOf(parts[i]) + parts[i].length()));
            }
        }
        return result.toString();
    }
    
    /**
     * Formate un numéro de téléphone au format français (XX.XX.XX.XX.XX).
     * Vérifie la validité du numéro (10 chiffres) et applique le formatage.
     * 
     * @param numero Le numéro à formater
     * @return Le numéro formaté ou message d'erreur si invalide
     */
    public String formatNumeroTelephone(String numero) {
        // Vérification si déjà un message d'erreur
        if (numero != null && numero.equals(NUMERO_INCORRECT)) {
            return numero;
        }
        
        // Nettoyage du numéro (conservation uniquement des chiffres)
        String cleanNumber = numero != null ? numero.replaceAll("[^0-9]", "") : null;
        
        // Vérification de la validité (10 chiffres)
        if (cleanNumber == null || !cleanNumber.matches("\\d{10}")) {
            System.out.printf("Le numéro de téléphone %s n'est pas conforme !%n", numero);
            return NUMERO_INCORRECT;
        }
        
        // Formatage au format français XX.XX.XX.XX.XX
        return String.format("%s.%s.%s.%s.%s",
            cleanNumber.substring(0, 2),
            cleanNumber.substring(2, 4),
            cleanNumber.substring(4, 6),
            cleanNumber.substring(6, 8),
            cleanNumber.substring(8, 10));
    }
}