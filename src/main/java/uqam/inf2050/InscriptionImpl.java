package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InscriptionImpl {
    private final List<Inscription> inscriptions = new ArrayList<>();

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
}