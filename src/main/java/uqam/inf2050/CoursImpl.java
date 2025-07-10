package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'une structure de gestion de Cours.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class CoursImpl {
    /**
     * Attribut liste de cours.
     */
    private List<Cours> cours = new ArrayList<>();

    /**
     * Ajoute un cours à la liste.
     *
     * @param e le cours à ajouter
     */
    public void addCours(final Cours e) {
        cours.add(e);
    }

    /**
     * Recherche un cours à partir de son sigle.
     *
     * @param sigle le sigle du cours recherché
     * @return le cours correspondant au sigle, ou un cours vide
     *          s'il n'est pas trouvé
     */
    public Cours getcours(final String sigle) {
        Cours cour = new Cours();

        for (Cours c : cours) {
            if (c.getSigle().equals(sigle)) {
                cour = c;
            }
        }

        return cour;
    }
}
