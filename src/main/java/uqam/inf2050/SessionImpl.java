package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SessionImpl {
    List<Session> sessions = new ArrayList<>();

    public void addSession(Session e) {sessions.add(e);}

    public Session getSession(Number codeSession) {
        Session session = new Session();

        for (Session s : sessions) {
            if (s.getCodeSession().equals(codeSession)) {
                session = s;
            }
        }

        return session;
    }

    public Session getSessionDate(LocalDate dateDebut) {
        Session session = new Session();

        for (Session s : sessions) {
            if (s.getDateDebut().equals(dateDebut)) {
                session = s;
            }
        }

        return session;
    }
}
