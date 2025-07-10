package uqam.inf2050;

/**
 * Représente un groupe de cours, associant un cours, un enseignant,
 * une session, un nombre maximal d'inscriptions et un local.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class GroupeCours {

    private Cours cours;
    private Enseignant enseignant;
    private Session session;
    private Number maxInscription;
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
     * @param cours le cours à définir
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    /**
     * Définit l'enseignant responsable de ce groupe.
     *
     * @param enseignant l'enseignant à définir
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    /**
     * Définit la session durant laquelle ce groupe est offert.
     *
     * @param session la session à définir
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * Définit le nombre maximal d'inscriptions autorisé.
     *
     * @param maxInscription le nombre maximal à définir
     */
    public void setMaxInscription(Number maxInscription) {
        this.maxInscription = maxInscription;
    }

    /**
     * Définit le local où se tiennent les cours.
     *
     * @param local le local à définir
     */
    public void setLocal(String local) {
        this.local = local;
    }
}
