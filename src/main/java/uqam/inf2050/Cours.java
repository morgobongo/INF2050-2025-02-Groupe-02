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

    /**
     * Attribut sigle.
     */
    private String sigle;
    /**
     * Attribut titre du cours.
     */
    private String titre;
    /**
     * Attribut description.
     */
    private String description;
    /**
     * Attribut nombre de credits.
     */
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
     * @param nouveauSigle le sigle à définir
     */
    public void setSigle(final String nouveauSigle) {
        this.sigle = nouveauSigle;
    }

    /**
     * Définit le titre du cours.
     *
     * @param nouveauTitre le titre à définir
     */
    public void setTitre(final String nouveauTitre) {
        this.titre = nouveauTitre;
    }

    /**
     * Définit la description du cours.
     *
     * @param nouvelleDescription la description à définir
     */
    public void setDescription(final String nouvelleDescription) {
        this.description = nouvelleDescription;
    }

    /**
     * Définit le nombre de crédits du cours.
     *
     * @param nouveauNbCredits le nombre de crédits à définir
     *                         (en chaîne de caractères)
     */
    public void setNbCredits(final String nouveauNbCredits) {
        this.nbCredits = nouveauNbCredits;
    }
}

