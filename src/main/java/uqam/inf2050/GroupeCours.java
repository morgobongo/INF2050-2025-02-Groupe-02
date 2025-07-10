package uqam.inf2050;

/**
 * Représente un groupe de cours, associant un cours, un enseignant,
 * une session, un nombre maximal d'inscriptions et un local.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class GroupeCours {

    /**
     * Attribut cours.
     */
    private Cours cours;
    /**
     * Attribut enseignant.
     */
    private Enseignant enseignant;
    /**
     * Attribut session.
     */
    private Session session;
    /**
     * Attribut maximum d'inscription.
     */
    private Number maxInscription;
    /**
     * Attribut local.
     */
    private String local;

    // ======== Getters ========

    /**
     * Retourne le cours associé à ce groupe.
     *
     * @return le cours
     */
    public Cours getCours() {
        return cours;
    }

    /**
     * Retourne l'enseignant responsable de ce groupe.
     *
     * @return l'enseignant
     */
    public Enseignant getEnseignant() {
        return enseignant;
    }

    /**
     * Retourne la session durant laquelle ce groupe est offert.
     *
     * @return la session
     */
    public Session getSession() {
        return session;
    }

    /**
     * Retourne le nombre maximal d'inscriptions autorisé.
     *
     * @return le nombre maximal d'inscriptions
     */
    public Number getMaxInscription() {
        return maxInscription;
    }

    /**
     * Retourne le local où se tiennent les cours.
     *
     * @return le local
     */
    public String getLocal() {
        return local;
    }

    // ======== Setters ========

    /**
     * Définit le cours associé à ce groupe.
     *
     * @param nouveauCours le cours à définir
     */
    public void setCours(final Cours nouveauCours) {
        this.cours = nouveauCours;
    }

    /**
     * Définit l'enseignant responsable de ce groupe.
     *
     * @param nouvelEnseignant l'enseignant à définir
     */
    public void setEnseignant(final Enseignant nouvelEnseignant) {
        this.enseignant = nouvelEnseignant;
    }

    /**
     * Définit la session durant laquelle ce groupe est offert.
     *
     * @param nouvelleSession la session à définir
     */
    public void setSession(final Session nouvelleSession) {
        this.session = nouvelleSession;
    }

    /**
     * Définit le nombre maximal d'inscriptions autorisé.
     *
     * @param nouveauMaxInscription le nombre maximal à définir
     */
    public void setMaxInscription(final Number nouveauMaxInscription) {
        this.maxInscription = nouveauMaxInscription;
    }

    /**
     * Définit le local où se tiennent les cours.
     *
     * @param nouveauLocal le local à définir
     */
    public void setLocal(final String nouveauLocal) {
        this.local = nouveauLocal;
    }
}
