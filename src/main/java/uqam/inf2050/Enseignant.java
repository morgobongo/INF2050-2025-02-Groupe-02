package uqam.inf2050;

public class Enseignant {

    private String codeEnseignant;
    private String nom;
    private String prenom;

    // ======== Getters ========

    public String getCodeEnseignant() {
        return codeEnseignant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    // ======== Setters ========

    public void setCodeEnseignant(String codeEnseignant) {
        this.codeEnseignant = codeEnseignant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
