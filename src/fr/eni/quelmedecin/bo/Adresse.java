package fr.eni.quelmedecin.bo;

/**
 * Classe représentant une adresse française
 */
public class Adresse {
    private String mentionsCompl;
    private int numero;
    private String complNumero;
    private String rue;
    private int cp;
    private String ville;

    /**
     * Constructeur avec toutes les informations
     * @param mentionsCompl mentions complémentaires
     * @param numero numéro dans la voie
     * @param complNumero complément de numéro
     * @param rue nom de la rue
     * @param cp code postal
     * @param ville nom de la ville
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
    * Constructeur sans mentions complémentaires ni complément de numéro
     * @param numero numéro dans la voie
     * @param complNumero complément de numéro
     * @param rue nom de la rue
     * @param cp code postal
     * @param ville nom de la ville
     */
    public Adresse(int numero, String complNumero, String rue, int cp, String ville) {
        this(null, numero, complNumero, rue, cp, ville);
    }

    /**
     * Affiche l'adresse formatée
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
    public String getMentionsCompl() { return mentionsCompl; }
    public void setMentionsCompl(String mentionsCompl) { this.mentionsCompl = mentionsCompl; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getComplNumero() { return complNumero; }
    public void setComplNumero(String complNumero) { this.complNumero = complNumero; }

    public String getRue() { return rue; }
    public void setRue(String rue) { this.rue = rue; }

    public int getCp() { return cp; }
    public void setCp(int cp) { this.cp = cp; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
}