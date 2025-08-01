package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'une gestion des étudiants.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class EtudiantImpl {
    /**
     * Attribut liste d'etudiants.
     */
    private List<Etudiant> etudiants = new ArrayList<>();

    /**
     * Retourne la liste des etudiants.
     *
     * @return la liste des etudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * Ajoute un étudiant à la liste.
     *
     * @param e l'étudiant à ajouter
     */
    public void addEtudiant(final Etudiant e) {
        etudiants.add(e);
    }

    /**
     * Recherche un étudiant par son code permanent.
     *
     * @param codePermanent le code permanent de l'étudiant recherché
     * @return l'étudiant correspondant, ou un nouvel étudiant vide
     *          si non trouvé
     */
    public Etudiant getEtudiant(final String codePermanent) {
        Etudiant etudiant = new Etudiant();

        for (Etudiant e : etudiants) {
            if (e.getCodePermanent().equals(codePermanent)) {
                etudiant = e;
            }
        }

        return etudiant;
    }

    /**
     * Récupère la liste des étudiants inscrits dans un programme donné.
     *
     * @param codeProgramme le code du programme d'études
     * @return une liste d'étudiants inscrits dans ce programme
     */
    public List<Etudiant> getEtudiantsCodeProg(final Number codeProgramme) {
        List<Etudiant> etudiantsProgramme = new ArrayList<>();

        for (Etudiant e : etudiants) {
            if (e.getCodeProgramme().equals(codeProgramme)) {
                etudiantsProgramme.add(e);
            }
        }
        return etudiantsProgramme;
    }
}
