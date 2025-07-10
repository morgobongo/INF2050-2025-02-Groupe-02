package uqam.inf2050;

/**
 * Représente un étudiant avec un code permanent, un nom, un prénom
 * et un code de programme d'études.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Etudiant {

    private String codePermanent;
    private String nom;
    private String prenom;
    private Number codeProgramme;

    // ======== Getters ========

    /**
     * Retourne le code permanent de l'étudiant.
     *
     * @return le code permanent
     */
    public String getCodePermanent() {
        return codePermanent;
    }

    /**
     * Retourne le nom de l'étudiant.
     *
     * @return le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de l'étudiant.
     *
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le code du programme d'études de l'étudiant.
     *
     * @return le code du programme
     */
    public Number getCodeProgramme() {
        return codeProgramme;
    }

    // ======== Setters ========

    /**
     * Définit le code permanent de l'étudiant.
     *
     * @param codePermanent le code permanent à définir
     */
    public void setCodePermanent(String codePermanent) {
        this.codePermanent = codePermanent;
    }

    /**
     * Définit le nom de l'étudiant.
     *
     * @param nom le nom de famille à définir
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le prénom de l'étudiant.
     *
     * @param prenom le prénom à définir
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Définit le code du programme d'études de l'étudiant.
     *
     * @param codeProgramme le code du programme à définir
     */
    public void setCodeProgramme(Number codeProgramme) {
        this.codeProgramme = codeProgramme;
    }
}