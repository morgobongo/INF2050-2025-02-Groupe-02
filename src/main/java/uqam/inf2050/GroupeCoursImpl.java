package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GroupeCoursImpl {
    List<GroupeCours> groupesCours = new ArrayList<>();
    List<Inscription> inscriptions = new ArrayList<>();

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public void addGroupeCours(GroupeCours e) {groupesCours.add(e);}

    public GroupeCours getGroupeCours(String cours, Enseignant enseignant) {
        GroupeCours groupeCours  = new GroupeCours();

        for (GroupeCours g : groupesCours) {
            if (g.getCours().getSigle().equals(cours) && g.getEnseignant().equals(enseignant)) {
                groupeCours = g;
            }
        }

        return groupeCours;
    }

    public List<GroupeCours> getGroupeCoursSession(String session) {
        List<GroupeCours> groupeCoursSession = new ArrayList<>();

        for (GroupeCours g : groupesCours) {
            if (g.getSession().equals(session)) {
                groupeCoursSession.add(g);
            }
        }
        return groupeCoursSession;
    }

    public List<GroupeCours> getGroupeCoursMaxInscription(Number maxInscription) {
        List<GroupeCours> groupeCoursMaxInscription = new ArrayList<>();
        for (GroupeCours g : groupesCours) {
            if (g.getMaxInscription().equals(maxInscription)) {
                groupeCoursMaxInscription.add(g);
            }
        }
        return groupeCoursMaxInscription;
    }

    /**
     * Vérifie si un cours se donne dans la session en cours
     *
     * @param sigleCours Le sigle du cours à vérifier
     * @return true si le cours se donne dans la session en cours, false sinon
     */
    public boolean verifierCoursSessionEnCours(String sigleCours) {
        if (sigleCours == null || sigleCours.trim().isEmpty()) {
            return false;
        }

        LocalDate jourMeme = LocalDate.now();

        for (GroupeCours gc : groupesCours) {
            if (gc.getCours() != null &&
                    sigleCours.equals(gc.getCours().getSigle()) &&
                    gc.getSession() != null) {

                LocalDate dateDebut = gc.getSession().getDateDebut();
                LocalDate dateFin = gc.getSession().getDateFin();

                if (dateDebut != null && dateFin != null &&
                        !jourMeme.isBefore(dateDebut) && !jourMeme.isAfter(dateFin)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Récupère la liste des cours enseignés dans un programme donné dans la session en cours
     *
     * @param codeProgramme Le code du programme
     * @return Liste des cours du programme dans la session en cours
     */
    public List<Cours> getCourseProgrammeSessionEnCours(Number codeProgramme) {
        List<Cours> coursPrograme = new ArrayList<>();

        if (codeProgramme == null) {
            return coursPrograme;
        }

        LocalDate jourMeme = LocalDate.now();

        for (Inscription inscription : inscriptions) {
            if (inscription.getEtudiant() != null &&
                    codeProgramme.equals(inscription.getEtudiant().getCodeProgramme()) &&
                    inscription.getGroupe() != null &&
                    inscription.getGroupe().getSession() != null) {

                Session session = inscription.getGroupe().getSession();
                LocalDate dateDebut = session.getDateDebut();
                LocalDate dateFin = session.getDateFin();

                // Vérifier si la session est en cours
                if (dateDebut != null && dateFin != null &&
                        !jourMeme.isBefore(dateDebut) && !jourMeme.isAfter(dateFin)) {

                    Cours cours = inscription.getGroupe().getCours();
                    if (cours != null && !coursPrograme.contains(cours)) {
                        coursPrograme.add(cours);
                    }
                }
            }
        }

        return coursPrograme;
    }

}
