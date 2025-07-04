import java.time.LocalDate;

public class Session {
    private Number codeSession;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // ======== Getters ========

    public Number getCodeSession() {
        return codeSession;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    // ======== Setters ========

    public void setCodeSession(Number codeSession) {
        this.codeSession = codeSession;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
