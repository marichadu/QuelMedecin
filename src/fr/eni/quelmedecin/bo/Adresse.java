package fr.eni.quelmedecin.bo;

/**
 * Classe représentant une adresse postale française.
 * Gère le formatage et l'affichage selon les normes postales françaises.
 * 
 * @author Mariami
 * @version 1.0
 */
public class Adresse {
     /** Mentions complémentaires (bâtiment, étage, etc.) */
     private String mentionsCompl;    
     /** Numéro dans la voie */
     private int numero;     
     /** Complément de numéro (bis, ter, etc.) */
     private String complNumero;     
     /** Nom de la rue, avenue, boulevard, etc. */
     private String rue;     
     /** Code postal sur 5 chiffres */
     private int cp;     
     /** Nom de la ville */
     private String ville;
     
     // Constructeurs

     /**
     * Constructeur complet d'une adresse
     * Permet de créer une adresse avec tous les éléments possibles
     * 
     * @param mentionsCompl Mentions complémentaires (peut être null)
     * @param numero Numéro dans la voie
     * @param complNumero Complément de numéro (peut être null)
     * @param rue Nom de la rue
     * @param cp Code postal
     * @param ville Nom de la ville
     */
    public Adresse(String mentionsCompl, int numero, String complNumero, 
                  String rue, int cp, String ville) {
        this.mentionsCompl = mentionsCompl;
        this.numero = numero;
        this.complNumero = complNumero;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }

    /**
     * Constructeur simplifié sans mentions complémentaires
     * Utilise le constructeur complet avec des valeurs null pour les champs optionnels
     * 
     * @param numero Numéro dans la voie
     * @param complNumero Complément de numéro (peut être null)
     * @param rue Nom de la rue
     * @param cp Code postal
     * @param ville Nom de la ville
     */
    public Adresse(int numero, String complNumero, String rue, int cp, String ville) {
        this(null, numero, complNumero, rue, cp, ville);
    }

     /**
     * Affiche l'adresse selon le format postal français
     * Format :
     * [Mentions complémentaires]
     * Numéro[Complément] Rue
     * Code postal VILLE
     */
    public void afficher() {
        if (mentionsCompl != null) {
            System.out.println(mentionsCompl);
        }
        System.out.printf("%d%s %s%n", 
            numero,
            complNumero != null ? complNumero : "",
            rue);
        System.out.printf("%d %s%n", cp, ville.toUpperCase());
    }

    // Getters and Setters

    /**
     * @return Les mentions complémentaires de l'adresse
     */
    public String getMentionsCompl() { 
        return mentionsCompl; 
    }

    /**
     * @param mentionsCompl Nouvelles mentions complémentaires
     */
    public void setMentionsCompl(String mentionsCompl) { 
        this.mentionsCompl = mentionsCompl; 
    }

    /**
     * @return Le numéro dans la voie
     */
    public int getNumero() { 
        return numero; 
    }

    /**
     * @param numero Nouveau numéro dans la voie
     */
    public void setNumero(int numero) { 
        this.numero = numero; 
    }

    /**
     * @return Le complément de numéro (bis, ter, etc.)
     */
    public String getComplNumero() { 
        return complNumero; 
    }

    /**
     * @param complNumero Nouveau complément de numéro
     */
    public void setComplNumero(String complNumero) { 
        this.complNumero = complNumero; 
    }

    /**
     * @return Le nom de la rue
     */
    public String getRue() { 
        return rue; 
    }

    /**
     * @param rue Nouveau nom de rue
     */
    public void setRue(String rue) { 
        this.rue = rue; 
    }

    /**
     * @return Le code postal
     */
    public int getCp() { 
        return cp; 
    }

    /**
     * @param cp Nouveau code postal
     */
    public void setCp(int cp) { 
        this.cp = cp; 
    }

    /**
     * @return Le nom de la ville
     */
    public String getVille() { 
        return ville; 
    }

    /**
     * @param ville Nouveau nom de ville
     */
    public void setVille(String ville) { 
        this.ville = ville; 
    }
}

