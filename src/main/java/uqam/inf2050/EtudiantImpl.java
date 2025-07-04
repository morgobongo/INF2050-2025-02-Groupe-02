package uqam.inf2050;

import java.util.ArrayList;
import java.util.List;

public class EtudiantImpl {
    List<Etudiant> etudiants = new ArrayList<>();

    public void addEtudiant(Etudiant e) {etudiants.add(e);}

    public Etudiant getEtudiant(String codePermanent) {
        Etudiant etudiant = new Etudiant();

        for (Etudiant e : etudiants) {
            if (e.getCodePermanent().equals(codePermanent)) {
                etudiant = e;
            }
        }

        return etudiant;
    }

    public List<Etudiant> getEtudiantsCodeProgramme(Number codeProgramme) {
        List<Etudiant> etudiantsProgramme = new ArrayList<>();

        for (Etudiant e : etudiants) {
            if (e.getCodeProgramme().equals(codeProgramme)) {
                etudiantsProgramme.add(e);
            }
        }
        return etudiantsProgramme;
    }
}
