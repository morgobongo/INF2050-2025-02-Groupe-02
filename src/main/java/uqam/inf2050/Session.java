package uqam.inf2050;

import java.time.LocalDate;

/**
 * Représente une session académique avec un code, une date de début
 * et une date de fin.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class Session {
    private Number codeSession;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // ======== Getters ========

    /**
     * Retourne le code de la session.
     *
     * @return le code de la session
     */
    public Number getCodeSession() {
        return codeSession;
    }

    /**
     * Retourne la date de début de la session.
     *
     * @return la date de début
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * Retourne la date de fin de la session.
     *
     * @return la date de fin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    // ======== Setters ========

    /**
     * Définit le code de la session.
     *
     * @param codeSession le code à définir
     */
    public void setCodeSession(Number codeSession) {
        this.codeSession = codeSession;
    }

    /**
     * Définit la date de début de la session.
     *
     * @param dateDebut la date à définir
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Définit la date de fin de la session.
     *
     * @param dateFin la date à définir
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
