public class Etudiant {

    private String codePermanent;
    private String nom;
    private String prenom;
    private Number codeProgramme;

    // ======== Getters ========

    public String getCodePermanent() {
        return codePermanent;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Number getCodeProgramme() {
        return codeProgramme;
    }

    // ======== Setters ========

    public void setCodePermanent(String codePermanent) {
        this.codePermanent = codePermanent;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCodeProgramme(Number codeProgramme) {
        this.codeProgramme = codeProgramme;
    }
}