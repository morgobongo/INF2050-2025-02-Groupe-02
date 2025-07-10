package uqam.inf2050;

/**
 * Représente un enseignant avec un code unique, un nom et un prénom.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Enseignant {

    private String codeEnseignant;
    private String nom;
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
     * @param codeEnseignant le code unique à définir
     */
    public void setCodeEnseignant(String codeEnseignant) {
        this.codeEnseignant = codeEnseignant;
    }

    /**
     * Définit le nom de l'enseignant.
     *
     * @param nom le nom de famille à définir
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le prenom de l'enseignant.
     *
     * @param prenom le prenom à définir
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
