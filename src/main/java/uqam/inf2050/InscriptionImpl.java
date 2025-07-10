package uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de la gestion des inscriptions des
 * étudiants aux groupes de cours.
 *
 * @author Equipe 2
 * @version 1.0
 */
public class InscriptionImpl {
    /**
     * Constante du mois de debut de la session d'automne.
     */
    public static final int MOIS_AUTOMNE = 9;

    /**
     * Attribut liste d'inscriptions.
     */
    private List<Inscription> inscriptions = new ArrayList<>();

    /**
     * Retourne la liste des inscriptions.
     *
     * @return la liste des inscriptions
     */
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    /**
     * Ajoute une inscription à la liste.
     *
     * @param ins l'inscription à ajouter
     */
    public void addInscription(final Inscription ins) {
        inscriptions.add(ins);
    }

    /**
     * Calcule le code du programme avec le plus haut pourcentage
     * d'inscriptions pour la session en cours.
     *
     * @return le code du programme avec le meilleur taux d'inscription,
     *         ou null si aucune session en cours n'est trouvée
     */
    public Number getProgrammePourcentageEleveSessionEnCours() {
        LocalDate maintenant = LocalDate.now();
        Number codeSessionEnCours = null;

        // 1. Trouver une session en cours
        // (la première trouvée dans les inscriptions)
        for (int i = 0; i < inscriptions.size(); i++) {
            Session s = inscriptions.get(i).getGroupe().getSession();
            boolean sessionEnCours = !maintenant.isBefore(s.getDateDebut())
                    && !maintenant.isAfter(s.getDateFin());

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

            boolean memeSession =
                    session.getCodeSession().equals(codeSessionEnCours);

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
                if (taux > meilleurTaux) {
                    meilleurTaux = taux;
                    meilleurProgramme = programmes.get(i);
                }
            }
        }
        return meilleurProgramme;
    }

    /**
     * Calcule le nombre total d'étudiants inscrits à un programme
     * durant les trois sessions (automne, hiver, été) d'une année donnée.
     *
     * @param codeProgramme le code du programme
     * @param anneeEtude l'année d'étude
     * @return le nombre total d'étudiants inscrits dans l'année
     */
    public Number getNombreEtudiantsInscritsProgrammeTroisSessions(
            final Number codeProgramme, final Number anneeEtude) {
        LocalDate dateSessionAutomne =
                LocalDate.of(anneeEtude.intValue(), MOIS_AUTOMNE, 1);
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        Number nbreEtudiants = 0;

        for (Inscription i:inscriptions) {
            if (i.getEtudiant().getCodeProgramme().equals(codeProgramme)
            && (i.getDateInscription().isEqual(dateSessionAutomne)
                    || i.getDateInscription().isAfter(dateSessionAutomne))
            && i.getDateInscription().isBefore(
                    dateSessionAutomne.plusYears(1))) {
                if (!etudiants.contains(i.getEtudiant())) {
                etudiants.add(i.getEtudiant());
                }
            }
        }

        nbreEtudiants = etudiants.size();

        return nbreEtudiants;
    }

    /**
     * Compare le nombre d'étudiants inscrits à un programme entre
     * deux années consécutives.
     *
     * @param codeProgramme le code du programme
     * @param annee1 la première année
     * @param annee2 la deuxième année
     * @return la différence du nombre d'inscriptions entre annee2 et annee1
     */
    public Number comparerNombreEtudiantsInscritsProgrammeDeuxAnsConsecutives(
            final Number codeProgramme, final Number annee1,
            final Number annee2) {
        Number comparaison = 0;

        comparaison = getNombreEtudiantsInscritsProgrammeTroisSessions(
                codeProgramme, annee2).intValue()
                - getNombreEtudiantsInscritsProgrammeTroisSessions(
                        codeProgramme, annee1).intValue();

        return  comparaison;
    }

    /**
     * Récupère la liste des étudiants inscrits dans un groupe-cours
     * donné selon le sigle, le code de session et le local.
     *
     * @param sigle le sigle du cours
     * @param codeSession le code de la session
     * @param local le local du groupe-cours
     * @return la liste des étudiants inscrits correspondant aux critères
     */
    public List<Etudiant> getEtudiantsInscritsGroupeCours(
            final String sigle, final Number codeSession, final String local) {
        List<Etudiant> etudiantsInscritsGroupeCours = new ArrayList<>();

        for (Inscription i : inscriptions) {
            if (i.getGroupe().getCours().getSigle().equals(sigle)
                    && i.getGroupe().getSession().getCodeSession().equals(
                            codeSession)
                    && i.getGroupe().getLocal().equals(local)) {
                etudiantsInscritsGroupeCours.add(i.getEtudiant());
            }
        }
        return etudiantsInscritsGroupeCours;
    }

    /**
     * Calcule le nombre d'étudiants inscrits, à date, dans un groupe-cours
     * donné selon le sigle, le code de session et le local.
     *
     * @param sigle le sigle du cours
     * @param codeSession le code de la session
     * @param local le local du groupe-cours
     * @return le nombre d'étudiants inscrits
     */
    public Number getNombreEtudiantsInscritsGroupeCours(
            final String sigle, final Number codeSession, final String local) {
        List<Etudiant> nombreEtudiantsInscritsGroupeCours
                = getEtudiantsInscritsGroupeCours(sigle, codeSession, local);

        return nombreEtudiantsInscritsGroupeCours.size();
    }

}
