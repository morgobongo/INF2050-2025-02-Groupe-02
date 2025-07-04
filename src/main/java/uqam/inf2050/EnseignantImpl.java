package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

public class EnseignantImpl {

    List<Enseignant> enseignants = new ArrayList<>();

    public void addEnseignant(Enseignant e) {enseignants.add(e);}

    public Enseignant getEnseignant(String codeEnseignant) {
        Enseignant enseignant = new Enseignant();

        for (Enseignant e : enseignants) {
            if (e.getCodeEnseignant().equals(codeEnseignant)) {
                enseignant = e;
            }
        }

        return enseignant;
    }
}
