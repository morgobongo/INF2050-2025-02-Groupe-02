package uqam.inf2050;

/**
 * Représente un étudiant avec un code permanent, un nom, un prénom
 * et un code de programme d'études.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Etudiant {

    /**
     * Attribut code permanent.
     */
    private String codePermanent;
    /**
     * Attribut nom.
     */
    private String nom;
    /**
     * Attribut prenom.
     */
    private String prenom;
    /**
     * Attribut code du programme.
     */
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
     * @param nouveauCodePermanent le code permanent à définir
     */
    public void setCodePermanent(final String nouveauCodePermanent) {
        this.codePermanent = nouveauCodePermanent;
    }

    /**
     * Définit le nom de l'étudiant.
     *
     * @param nouveauNom le nom de famille à définir
     */
    public void setNom(final String nouveauNom) {
        this.nom = nouveauNom;
    }

    /**
     * Définit le prénom de l'étudiant.
     *
     * @param nouveauPrenom le prénom à définir
     */
    public void setPrenom(final String nouveauPrenom) {
        this.prenom = nouveauPrenom;
    }

    /**
     * Définit le code du programme d'études de l'étudiant.
     *
     * @param nouveauCodeProgramme le code du programme à définir
     */
    public void setCodeProgramme(final Number nouveauCodeProgramme) {
        this.codeProgramme = nouveauCodeProgramme;
    }
}
