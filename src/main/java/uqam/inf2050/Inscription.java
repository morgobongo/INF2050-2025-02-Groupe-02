package uqam.inf2050;

import java.time.LocalDate;

/**
 * Représente une inscription d'un étudiant à un groupe de cours.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Inscription {
    private Etudiant etudiant;
    private GroupeCours groupe;
    private LocalDate dateInscription;
    private LocalDate dateAbandon;
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
     * Retourne la date d'abandon
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
     * @param etudiant l'étudiant à définir
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    /**
     * Définit le groupe cours.
     *
     * @param groupe le groupe cours à définir
     */
    public void setGroupe(GroupeCours groupe) {
        this.groupe = groupe;
    }

    /**
     * Définit la date d'inscription.
     *
     * @param dateInscription la date à définir
     */
    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * Définit la date d'abandon.
     *
     * @param dateAbandon la date à définir
     */
    public void setDateAbandon(LocalDate dateAbandon) {
        this.dateAbandon = dateAbandon;
    }

    /**
     * Définit la note obtenue.
     *
     * @param note la note à définir
     */
    public void setNote(Number note) {
        this.note = note;
    }
}
