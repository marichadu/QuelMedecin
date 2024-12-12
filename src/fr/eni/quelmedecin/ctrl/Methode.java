package fr.eni.quelmedecin.ctrl;

/**
 * Classe utilitaire pour le formatage des données
 */
public class Methode {
    private static final Methode instance = new Methode();
    
    private Methode() {}
    
    public static Methode getMethode() {
        return instance;
    }
    
    /**
     * Met en majuscule la première lettre de chaque mot
     * @param str la chaîne à formater
     * @return la chaîne avec les premières lettres en majuscule
     */
    public String premiereEnMajuscule(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String[] parts = str.split("[ '-]");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                result.append(parts[i].substring(0, 1).toUpperCase())
                      .append(parts[i].substring(1).toLowerCase());
            }
            if (i < parts.length - 1) {
                result.append(str.charAt(str.indexOf(parts[i]) + parts[i].length()));
            }
        }
        return result.toString();
    }
    
    /**
     * Formate un numéro de téléphone au format XX.XX.XX.XX.XX
     * @param numero le numéro à formater
     * @return le numéro formaté ou "<< numero incorrect >>" si invalide
     */
    public String formatNumeroTelephone(String numero) {
        // Don't format if it's already the error message
        if (numero != null && numero.equals("<< numero incorrect >>")) {
            return numero;
        }
        
        // Remove any existing formatting
        String cleanNumber = numero != null ? numero.replaceAll("[^0-9]", "") : null;
        
        if (cleanNumber == null || !cleanNumber.matches("\\d{10}")) {
            System.out.printf("Le numero de téléphone %s n'est pas conforme !%n", numero);
            return "<< numero incorrect >>";
        }
        
        return String.format("%s.%s.%s.%s.%s",
            cleanNumber.substring(0, 2),
            cleanNumber.substring(2, 4),
            cleanNumber.substring(4, 6),
            cleanNumber.substring(6, 8),
            cleanNumber.substring(8, 10));
    }
}