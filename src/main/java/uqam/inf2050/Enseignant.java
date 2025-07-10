package uqam.inf2050;

/**
 * Représente un enseignant avec un code unique, un nom et un prénom.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Enseignant {

    /**
     * Attribut code de l'enseignant.
     */
    private String codeEnseignant;
    /**
     * Attribut nom de l'enseignant.
     */
    private String nom;
    /**
     * Attribut prenom de l'enseignant.
     */
    private String prenom;

    // ======== Getters ========

    /**
     * Retourne le code de l'enseignant.
     *
     * @return le code unique de l'enseignant
     */
    public String getCodeEnseignant() {
        return codeEnseignant;
    }

    /**
     * Retourne le nom de l'enseignant.
     *
     * @return le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de l'enseignant.
     *
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    // ======== Setters ========

    /**
     * Définit le code de l'enseignant.
     *
     * @param nouveauCodeEnseignant le code unique à définir
     */
    public void setCodeEnseignant(final String nouveauCodeEnseignant) {

        this.codeEnseignant = nouveauCodeEnseignant;
    }

    /**
     * Définit le nom de l'enseignant.
     *
     * @param nouveauNom le nom de famille à définir
     */
    public void setNom(final String nouveauNom) {

        this.nom = nouveauNom;
    }

    /**
     * Définit le prenom de l'enseignant.
     *
     * @param nouveauPrenom le prenom à définir
     */
    public void setPrenom(final String nouveauPrenom) {
        this.prenom = nouveauPrenom;
    }
}
