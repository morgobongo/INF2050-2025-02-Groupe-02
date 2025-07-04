import java.time.LocalDate;

public class Inscription {
    private Etudiant etudiant;
    private GroupeCours groupe;
    private LocalDate dateInscription;
    private LocalDate dateAbandon;
    private Number note;

    // ======== Getters ========

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public GroupeCours getGroupe() {
        return groupe;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public LocalDate getDateAbandon() {
        return dateAbandon;
    }

    public Number getNote() {
        return note;
    }

    // ======== Setters ========

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setGroupe(GroupeCours groupe) {
        this.groupe = groupe;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setDateAbandon(LocalDate dateAbandon) {
        this.dateAbandon = dateAbandon;
    }

    public void setNote(Number note) {
        this.note = note;
    }
}
