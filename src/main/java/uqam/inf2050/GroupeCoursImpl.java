package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de la gestion des groupes de cours et de leurs inscriptions.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class GroupeCoursImpl {
    /**
     * Attribut liste de groupe-cours.
     */
    private List<GroupeCours> groupesCours = new ArrayList<>();
    /**
     * Attribut liste d'inscriptions.
     */
    private List<Inscription> inscriptions = new ArrayList<>();

    /**
     * Définit la liste des inscriptions.
     *
     * @param nouvelleInscriptions la liste des inscriptions à définir
     */
    public void setInscriptions(final List<Inscription> nouvelleInscriptions) {
        this.inscriptions = nouvelleInscriptions;
    }

    /**
     * Ajoute un groupe de cours à la liste.
     *
     * @param e le groupe de cours à ajouter
     */
    public void addGroupeCours(final GroupeCours e) {
        groupesCours.add(e);
    }

    /**
     * Recherche un groupe de cours selon le sigle du cours et l'enseignant.
     *
     * @param cours le sigle du cours recherché
     * @param enseignant l'enseignant responsable
     * @return le groupe de cours correspondant,
     *          ou un nouveau groupe vide si non trouvé
     */
    public GroupeCours getGroupeCours(
            final String cours, final Enseignant enseignant) {
        GroupeCours groupeCours  = new GroupeCours();

        for (GroupeCours g : groupesCours) {
            if (g.getCours().getSigle().equals(cours)
                    && g.getEnseignant().equals(enseignant)) {
                groupeCours = g;
            }
        }

        return groupeCours;
    }

    /**
     * Récupère la liste des groupes de cours pour une session donnée.
     *
     * @param session la session recherchée
     * @return la liste des groupes de cours de la session
     */
    public List<GroupeCours> getGroupeCoursSession(final String session) {
        List<GroupeCours> groupeCoursSession = new ArrayList<>();

        for (GroupeCours g : groupesCours) {
            if (g.getSession().equals(session)) {
                groupeCoursSession.add(g);
            }
        }
        return groupeCoursSession;
    }

    /**
     * Récupère la liste des groupes de cours ayant un nombre maximal
     * d'inscriptions donné.
     *
     * @param maxInscription le nombre maximal d'inscriptions recherché
     * @return la liste des groupes de cours correspondants
     */
    public List<GroupeCours> getGroupeCoursMaxInscription(
            final Number maxInscription) {
        List<GroupeCours> groupeCoursMaxInscription = new ArrayList<>();
        for (GroupeCours g : groupesCours) {
            if (g.getMaxInscription().equals(maxInscription)) {
                groupeCoursMaxInscription.add(g);
            }
        }
        return groupeCoursMaxInscription;
    }

    /**
     * Vérifie si un cours se donne dans la session en cours.
     *
     * @param sigleCours Le sigle du cours à vérifier
     * @return true si le cours se donne dans la session en cours, false sinon
     */
    public boolean verifierCoursSessionEnCours(final String sigleCours) {
        if (sigleCours == null || sigleCours.trim().isEmpty()) {
            return false;
        }

        LocalDate jourMeme = LocalDate.now();

        for (GroupeCours gc : groupesCours) {
            if (gc.getCours() != null
                    && sigleCours.equals(gc.getCours().getSigle())
                    && gc.getSession() != null) {

                LocalDate dateDebut = gc.getSession().getDateDebut();
                LocalDate dateFin = gc.getSession().getDateFin();

                if (dateDebut != null && dateFin != null
                        && !jourMeme.isBefore(dateDebut)
                        && !jourMeme.isAfter(dateFin)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Récupère la liste des cours enseignés dans un programme
     * donné dans la session en cours.
     *
     * @param codeProgramme Le code du programme
     * @return Liste des cours du programme dans la session en cours
     */
    public List<Cours> getCourseProgrammeSessionEnCours(
            final Number codeProgramme) {
        List<Cours> coursPrograme = new ArrayList<>();

        if (codeProgramme == null) {
            return coursPrograme;
        }

        LocalDate jourMeme = LocalDate.now();

        for (Inscription inscription : inscriptions) {
            if (inscription.getEtudiant() != null
                    && codeProgramme.equals(
                            inscription.getEtudiant().getCodeProgramme())
                    && inscription.getGroupe() != null
                    && inscription.getGroupe().getSession() != null) {

                Session session = inscription.getGroupe().getSession();
                LocalDate dateDebut = session.getDateDebut();
                LocalDate dateFin = session.getDateFin();

                // Vérifier si la session est en cours
                if (dateDebut != null && dateFin != null
                        && !jourMeme.isBefore(dateDebut)
                        && !jourMeme.isAfter(dateFin)) {

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
