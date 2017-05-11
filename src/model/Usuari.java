package model;

/**
 *
 * @author Eric
 */
public class Usuari {
    
    private String nif;
    private String nom;
    private String cognoms;

    public Usuari() {
    }

    public Usuari(String nif, String nom, String cognoms) {
        this.nif = nif;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @Override
    public String toString() {
        return "Usuari{" + "nif=" + nif + ", nom=" + nom + ", cognoms=" + cognoms + '}';
    }
    
    
    
}
