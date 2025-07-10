package uqam.inf2050;

import java.time.LocalDate;

/**
 * Représente une inscription d'un étudiant à un groupe de cours.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Inscription {
    /**
     * Attribut etudiant.
     */
    private Etudiant etudiant;
    /**
     * Attribut groupe-cours.
     */
    private GroupeCours groupe;
    /**
     * Attribut date d'inscription.
     */
    private LocalDate dateInscription;
    /**
     * Attribut date d'abandon.
     */
    private LocalDate dateAbandon;
    /**
     * Attribut note.
     */
    private Number note;

    // ======== Getters ========

    /**
     * Retourne l'étudiant inscrit.
     *
     * @return l'étudiant
     */
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     * Retourne le groupe de cours de l'inscription.
     *
     * @return le groupe de cours
     */
    public GroupeCours getGroupe() {
        return groupe;
    }

    /**
     * Retourne la date d'inscription.
     *
     * @return la date d'inscription
     */
    public LocalDate getDateInscription() {
        return dateInscription;
    }

    /**
     * Retourne la date d'abandon.
     *
     * @return la date d'abandon
     */
    public LocalDate getDateAbandon() {
        return dateAbandon;
    }

    /**
     * Retourne la note obtenue.
     *
     * @return la note
     */
    public Number getNote() {
        return note;
    }

    // ======== Setters ========
    /**
     * Définit l'étudiant inscrit.
     *
     * @param nouvelEtudiant l'étudiant à définir
     */
    public void setEtudiant(final Etudiant nouvelEtudiant) {
        this.etudiant = nouvelEtudiant;
    }

    /**
     * Définit le groupe cours.
     *
     * @param nouveauGroupe le groupe cours à définir
     */
    public void setGroupe(final GroupeCours nouveauGroupe) {
        this.groupe = nouveauGroupe;
    }

    /**
     * Définit la date d'inscription.
     *
     * @param nouvelleDateInscription la date à définir
     */
    public void setDateInscription(final LocalDate nouvelleDateInscription) {
        this.dateInscription = nouvelleDateInscription;
    }

    /**
     * Définit la date d'abandon.
     *
     * @param nouvelleDateAbandon la date à définir
     */
    public void setDateAbandon(final LocalDate nouvelleDateAbandon) {
        this.dateAbandon = nouvelleDateAbandon;
    }

    /**
     * Définit la note obtenue.
     *
     * @param nouvelleNote la note à définir
     */
    public void setNote(final Number nouvelleNote) {
        this.note = nouvelleNote;
    }
}
