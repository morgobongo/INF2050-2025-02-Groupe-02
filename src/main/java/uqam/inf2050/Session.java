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
    /**
     * Attribut code de session.
     */
    private Number codeSession;
    /**
     * Attribut date de debut.
     */
    private LocalDate dateDebut;
    /**
     * Attribut date de fin.
     */
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
     * @param nouveauCodeSession le code à définir
     */
    public void setCodeSession(final Number nouveauCodeSession) {
        this.codeSession = nouveauCodeSession;
    }

    /**
     * Définit la date de début de la session.
     *
     * @param nouvelleDateDebut la date à définir
     */
    public void setDateDebut(final LocalDate nouvelleDateDebut) {
        this.dateDebut = nouvelleDateDebut;
    }

    /**
     * Définit la date de fin de la session.
     *
     * @param nouvelleDateFin la date à définir
     */
    public void setDateFin(final LocalDate nouvelleDateFin) {
        this.dateFin = nouvelleDateFin;
    }
}
