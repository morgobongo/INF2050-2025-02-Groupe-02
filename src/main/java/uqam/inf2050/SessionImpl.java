package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de la gestion des sessions académiques.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class SessionImpl {
    /**
     * Attribut liste de sessions.
     */
    private List<Session> sessions = new ArrayList<>();

    /**
     * Ajoute une session à la liste.
     *
     * @param e la session à ajouter
     */
    public void addSession(final Session e) {
        sessions.add(e);
    }

    /**
     * Recherche une session à partir de son code.
     *
     * @param codeSession le code de la session recherché
     * @return la session correspondante, ou une Session vide si non trouvée
     */
    public Session getSession(final Number codeSession) {
        Session session = new Session();

        for (Session s : sessions) {
            if (s.getCodeSession().equals(codeSession)) {
                session = s;
            }
        }

        return session;
    }

    /**
     * Recherche une session à partir de sa date de début.
     *
     * @param dateDebut la date de début de la session recherchée
     * @return la session correspondante,
     *          ou une nouvelle session vide si non trouvée
     */
    public Session getSessionDate(final LocalDate dateDebut) {
        Session session = new Session();

        for (Session s : sessions) {
            if (s.getDateDebut().equals(dateDebut)) {
                session = s;
            }
        }

        return session;
    }
}
