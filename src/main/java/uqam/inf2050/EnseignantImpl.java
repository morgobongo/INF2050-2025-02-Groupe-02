package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'une structure de gestion des enseignants.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class EnseignantImpl {

    /**
     * Attribut liste d'enseignants.
     */
    private List<Enseignant> enseignants = new ArrayList<>();

    /**
     * Ajoute un enseignant à la liste.
     *
     * @param e l'enseignant à ajouter
     */
    public void addEnseignant(final Enseignant e) {
        enseignants.add(e);
    }

    /**
     * Recherche un enseignant par son code.
     *
     * @param codeEnseignant le code de l'enseignant recherché
     * @return l'enseignant correspondant, ou Enseignant vide si non trouvé
     */
    public Enseignant getEnseignant(final String codeEnseignant) {
        Enseignant enseignant = new Enseignant();

        for (Enseignant e : enseignants) {
            if (e.getCodeEnseignant().equals(codeEnseignant)) {
                enseignant = e;
            }
        }
        return enseignant;
    }
}
