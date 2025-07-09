package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InscriptionImpl {
    List<Inscription> inscriptions = new ArrayList<>();

    // Méthode pour ajouter une inscription à la liste
    public void addInscription(Inscription ins) {
        inscriptions.add(ins);
    }

    public Number getProgrammePourcentageEleveSessionEnCours(){
        LocalDate maintenant = LocalDate.now();
        Number codeSessionEnCours = null;

        // 1. Trouver une session en cours (la première trouvée dans les inscriptions)
        for (int i = 0; i < inscriptions.size(); i++) {
            Session s = inscriptions.get(i).getGroupe().getSession();
            boolean sessionEnCours = !maintenant.isBefore(s.getDateDebut()) && !maintenant.isAfter(s.getDateFin());

            if (codeSessionEnCours == null && sessionEnCours) {
                codeSessionEnCours = s.getCodeSession();
            }
        }
        if (codeSessionEnCours == null) {
            return null;
        }

        ArrayList<Number> programmes = new ArrayList<>();
        ArrayList<Integer> totalInscrits = new ArrayList<>();
        ArrayList<Integer> totalMax = new ArrayList<>();

        for (int i = 0; i < inscriptions.size(); i++) {
            Inscription ins = inscriptions.get(i);
            GroupeCours gc = ins.getGroupe();
            Session session = gc.getSession();

            boolean memeSession = session.getCodeSession().equals(codeSessionEnCours);

            if (memeSession) {
                Number codeProgramme = ins.getEtudiant().getCodeProgramme();
                int maxIns = gc.getMaxInscription().intValue();

                int index = programmes.indexOf(codeProgramme);

                if (index == -1) {
                    programmes.add(codeProgramme);
                    totalInscrits.add(1);
                    totalMax.add(maxIns);
                } else {
                    totalInscrits.set(index, totalInscrits.get(index) + 1);
                    totalMax.set(index, totalMax.get(index) + maxIns);
                }
            }
        }

        Number meilleurProgramme = null;
        double meilleurTaux = -1;

        for (int i = 0; i < programmes.size(); i++) {
            int inscrits = totalInscrits.get(i);
            int max = totalMax.get(i);

            boolean tauxValide = max > 0;

            if (tauxValide) {
                double taux = (double) inscrits / max;
                if(taux > meilleurTaux) {
                    meilleurTaux = taux;
                    meilleurProgramme = programmes.get(i);
                }
            }
        }
        return meilleurProgramme;
    }

    // Calculer le nombre total d'étudiants inscrits à un programme durant
    // les trois sessions (automne, hiver, été) de l'année d'étude
    public Number getNombreEtudiantsInscritsProgrammeTroisSessions
            (Number codeProgramme, Number anneeEtude) {
        LocalDate dateSessionAutomne = LocalDate.of(anneeEtude.intValue(), 9, 1);
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        Number nbreEtudiants = 0;

        for (Inscription i:inscriptions) {
            if(i.getEtudiant().getCodeProgramme().equals(codeProgramme)
            && (i.getDateInscription().isEqual(dateSessionAutomne) || i.getDateInscription().isAfter(dateSessionAutomne))
            && i.getDateInscription().isBefore(dateSessionAutomne.plusYears(1))) {
                if (!etudiants.contains(i.getEtudiant())) {
                etudiants.add(i.getEtudiant());
                }
            }
        }

        nbreEtudiants = etudiants.size();

        return nbreEtudiants;
    }


    //Comparer deux années consécutives (par exemple 2023-2024 et 2024-2025) en termes du nombre
    //d'inscriptions à un programme
    public Number comparerNombreEtudiantsInscritsProgrammeDeuxAnneesConsecutives(Number codeProgramme, Number annee1, Number annee2) {
        Number comparaison = 0;

        comparaison = getNombreEtudiantsInscritsProgrammeTroisSessions(codeProgramme, annee2).intValue() -
            getNombreEtudiantsInscritsProgrammeTroisSessions(codeProgramme, annee1).intValue();

        return  comparaison;
    }

}