package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

public class CoursImpl {
    List<Cours> cours = new ArrayList<>();

    public void addCours(Cours e) {cours.add(e);}

    public Cours getcours(String sigle) {
        Cours cour = new Cours();

        for (Cours c : cours) {
            if (c.getSigle().equals(sigle)) {
                cour = c;
            }
        }

        return cour;
    }
}