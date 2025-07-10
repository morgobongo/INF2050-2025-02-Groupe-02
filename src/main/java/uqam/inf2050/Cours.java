package uqam.inf2050;
/**
 * Représente un cours avec ses informations principales :
 * sigle, titre, description et nombre de crédits.
 *
 *
 * @author Equipe 2
 * @version 1.0
 */

public class Cours {

    private String sigle;
    private String titre;
    private String description;
    private String nbCredits;

    // ======== Getters ========

    /**
     * Retourne le sigle du cours.
     *
     * @return le sigle du cours
     */
    public String getSigle() {
        return sigle;
    }

    /**
     * Retourne le titre du cours.
     *
     * @return le titre du cours
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Retourne la description du cours.
     *
     * @return la description du cours
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retourne le nombre de crédits du cours.
     *
     * @return le nombre de crédits sous forme de chaîne
     */
    public String getNbCredits() {
        return nbCredits;
    }

// ======== Setters ========

    /**
     * Définit le sigle du cours.
     *
     * @param sigle le sigle à définir
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * Définit le titre du cours.
     *
     * @param titre le titre à définir
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Définit la description du cours.
     *
     * @param description la description à définir
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Définit le nombre de crédits du cours.
     *
     * @param nbCredits le nombre de crédits à définir (en chaîne de caractères)
     */
    public void setNbCredits(String nbCredits) {
        this.nbCredits = nbCredits;
    }
}

