package uqam.inf2050;

public class GroupeCours {

    private Cours cours;
    private Enseignant enseignant;
    private Session session;
    private Number maxInscription;
    private String local;

    // ======== Getters ========

    public Cours getCours() {
        return cours;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Session getSession() {
        return session;
    }

    public Number getMaxInscription() {
        return maxInscription;
    }

    public String getLocal() {
        return local;
    }

    // ======== Setters ========

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setMaxInscription(Number maxInscription) {
        this.maxInscription = maxInscription;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
