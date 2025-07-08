package uqam.inf2050;

//Librairies jUnit
import org.junit.*;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class GroupeCoursTest {
        static EtudiantImpl etudiants = new EtudiantImpl();
        static CoursImpl cours = new CoursImpl();
        static EnseignantImpl enseignants = new EnseignantImpl();
        static SessionImpl sessions = new SessionImpl();
        static GroupeCoursImpl groupesCours = new GroupeCoursImpl();
        static InscriptionImpl inscriptions = new InscriptionImpl();

        static FileReader fluxConnecteur;
        static BufferedReader fluxTampon;

        // S'exécute UNE FOIS avant tous les tests
        @BeforeClass
        public static void setUpBeforeClass() {
            PrintWriter pWriter;
            try {

                //Setup des etudiants
                pWriter = new PrintWriter((new PrintWriter("EtudiantsTest.csv")));
                pWriter.println("Code Permanent;Nom;Prenom;Code Programme");
                pWriter.println("ANDA12345;Andrews;Archie;123");
                pWriter.println("VASA65432;Vasquez;Alexandra;456");
                pWriter.println("FRYP78910;Fry;Philip;789");
                pWriter.println("BLAD11121;Blake;Daphne;123");
                pWriter.close();

                //Setup des cours
                pWriter = new PrintWriter((new PrintWriter("CoursTest.csv")));
                pWriter.println("Sigle;Titre;Description;Nombre Credits");
                pWriter.println("INF1070;Linux;Man moi ca;1");
                pWriter.println("MAT4681;Statistiques;Probablement probabiliste;2");
                pWriter.println("INF1132;Math Info;Never forget;3");
                pWriter.println("INF2171;Assembleur;Tout n'est que bits;4");
                pWriter.close();

                //Setup des enseignants
                pWriter = new PrintWriter((new PrintWriter("EnseignantsTest.csv")));
                pWriter.println("Code d'enseignant;Nom;Prenom");
                pWriter.println("1111;Poulin;Julien");
                pWriter.println("2222;Martin;Pauline");
                pWriter.println("3333;Lebeau;Pierre");
                pWriter.println("4444;Di Stasio;Josee");
                pWriter.close();

                //Setup des sessions
                pWriter = new PrintWriter((new PrintWriter("SessionsTest.csv")));
                pWriter.println("Code de sessions;Date de debut;Date de fin");
                pWriter.println("12024;2024,1,1;2024,4,30");
                pWriter.println("22024;2024,9,1;2024,12,31");
                pWriter.println("32024;2024,5,1;2024,8,31");

                pWriter.println("12025;2025,1,1;2025,4,30");
                pWriter.println("22025;2025,9,1;2025,12,31");
                pWriter.println("32025;2025,5,1;2025,8,31");
                pWriter.close();

                //Setup des groupes cours
                pWriter = new PrintWriter((new PrintWriter("GroupesCoursTest.csv")));
                pWriter.println("Cours;Enseignant;Session;Maximum Inscription;Local");

                pWriter.println("INF1070;1111;12024;25;R111");
                pWriter.println("INF2171;4444;12024;20;R222");

                pWriter.println("MAT4681;2222;22024;15;S111");

                pWriter.println("INF1132;3333;32024;30;S222");

                pWriter.println("INF2171;4444;12025;35;T111");

                pWriter.println("INF1070;3333;22025;23;T222");
                pWriter.println("INF2171;1111;22025;19;U111");

                pWriter.println("INF1070;1111;32025;25;R333");

                pWriter.println("MAT4681;2222;32026;32;U222");
                pWriter.close();

                //Setup des inscriptions
                pWriter = new PrintWriter((new PrintWriter("InscriptionsTest.csv")));
                pWriter.println("Etudiant;GroupeCours;Date d'inscription;Date d'abandon;Note");

                pWriter.println("ANDA12345;INF1070,1111;2024,1,1;2024,3,1;50");
                pWriter.println("VASA65432;INF1070,1111;2024,1,2;2024,3,2;52");
                pWriter.println("FRYP78910;INF1070,1111;2024,1,3;2024,3,3;54");
                pWriter.println("ANDA12345;INF1070,1111;2025,6,1;2025,7,1;85");

                pWriter.println("VASA65432;INF2171,4444;2024,1,2;2024,2,1;60");
                pWriter.println("ANDA12345;INF2171,4444;2024,1,1;2024,3,2;62");
                pWriter.println("BLAD11121;INF2171,4444;2024,1,4;2024,3,3;64");
                pWriter.println("FRYP78910;INF2171,4444;2024,1,3;2024,3,4;66");

                pWriter.println("FRYP78910;MAT4681,2222;2024,9,1;2024,10,1;70");
                pWriter.println("ANDA12345;MAT4681,2222;2024,9,2;2024,10,2;72");

                pWriter.println("BLAD11121;INF1132,3333;2024,6,1;2024,7,1;80");
                pWriter.println("VASA65432;INF1132,3333;2024,6,2;2024,7,2;82");

                pWriter.println("BLAD11121;INF2171,4444;2025,1,2;2025,3,2;92");
                pWriter.println("VASA65432;INF2171,4444;2025,1,3;2025,3,3;94");

                pWriter.println("VASA65432;INF1070,3333;2025,9,1;2025,10,1;40");
                pWriter.println("FRYP78910;INF1070,3333;2025,9,2;2025,10,2;42");

                pWriter.println("FRYP78910;INF2171,1111;2025,9,2;2025,10,2;32");

                pWriter.println("VASA65432;MAT4681,2222;2025,6,1;2025,7,1;20");
                pWriter.println("FRYP78910;MAT4681,2222;2025,6,3;2025,7,3;24");
                pWriter.println("BLAD11121;MAT4681,2222;2025,6,4;2025,7,4;26");
                pWriter.close();

            } catch (IOException e) {
                System.out.println("Erreur d'entrée / sortie");
            }
        }

        // S'exécute AVANT chaque méthode de test
        @Before
        public void setUp() {
            //Déclaration des variables
            String uneLigne;
            String[] attributs;

            try {
                //Creation etudiants
                fluxConnecteur = new FileReader("EtudiantsTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 4) {
                        //Récupération des informations
                        byte i = 0;
                        Etudiant etudiant = new Etudiant();

                        etudiant.setCodePermanent(attributs[i].trim());
                        i++;

                        etudiant.setNom(attributs[i].trim());
                        i++;

                        etudiant.setPrenom(attributs[i].trim());
                        i++;

                        etudiant.setCodeProgramme(Integer.parseInt(attributs[i].trim()));

                        //Attribution a la liste
                        etudiants.addEtudiant(etudiant);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }

                //Creation cours
                fluxConnecteur = new FileReader("CoursTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 4) {
                        //Récupération des informations
                        byte i = 0;
                        Cours cour = new Cours();

                        cour.setSigle(attributs[i].trim());
                        i++;

                        cour.setTitre(attributs[i].trim());
                        i++;

                        cour.setDescription(attributs[i].trim());
                        i++;

                        cour.setNbCredits(attributs[i].trim());

                        //Attribution a la liste
                        cours.addCours(cour);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }

                //Creation enseignants
                fluxConnecteur = new FileReader("EnseignantsTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 3) {
                        //Récupération des informations
                        byte i = 0;
                        Enseignant enseignant = new Enseignant();

                        enseignant.setCodeEnseignant(attributs[i].trim());
                        i++;

                        enseignant.setNom(attributs[i].trim());
                        i++;

                        enseignant.setPrenom(attributs[i].trim());

                        //Attribution a la liste
                        enseignants.addEnseignant(enseignant);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }

                //Creation sessions
                fluxConnecteur = new FileReader("SessionsTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 3) {
                        //Récupération des informations
                        Session session = getSession(attributs);

                        //Attribution a la liste
                        sessions.addSession(session);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }

                //Creation groupes cours
                fluxConnecteur = new FileReader("GroupesCoursTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 5) {
                        //Récupération des informations
                        byte i = 0;
                        GroupeCours groupeCours = new GroupeCours();

                        groupeCours.setCours(cours.getcours(attributs[i].trim()));
                        i++;

                        groupeCours.setEnseignant(enseignants.getEnseignant(attributs[i].trim()));
                        i++;

                        groupeCours.setSession(sessions.getSession(Integer.parseInt(attributs[i].trim())));
                        i++;

                        groupeCours.setMaxInscription(Integer.parseInt(attributs[i].trim()));
                        i++;

                        groupeCours.setLocal(attributs[i].trim());

                        //Attribution a la liste
                        groupesCours.addGroupeCours(groupeCours);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }

                //Creation inscriptions
                fluxConnecteur = new FileReader("InscriptionsTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 5) {
                        //Récupération des informations
                        byte i = 0;
                        String[] groupeCoursInsc;
                        String[] dates;
                        Inscription inscription = new Inscription();

                        inscription.setEtudiant(etudiants.getEtudiant(attributs[i].trim()));
                        i++;

                        groupeCoursInsc = attributs[i].split(",");
                        inscription.setGroupe(groupesCours.getGroupeCours(groupeCoursInsc[0], enseignants.getEnseignant(groupeCoursInsc[1])));
                        i++;

                        dates = attributs[i].split(",");
                        inscription.setDateInscription(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
                        i++;

                        dates = attributs[i].split(",");
                        inscription.setDateAbandon(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
                        i++;

                        inscription.setNote(Integer.parseInt(attributs[i].trim()));

                        //Attribution a la liste
                        inscriptions.addInscription(inscription);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erreur: Fichier non trouvé");
            } catch (IOException e) {
                System.out.println("Erreur d'entrée / sortie");
            } catch (NumberFormatException e) {
                System.out.println("Format invalide de donnée");
            }

            groupesCours.setInscriptions(inscriptions.inscriptions);
        }

    private static Session getSession(String[] attributs) {
        byte i = 0;
        String[] dates;
        Session session = new Session();

        session.setCodeSession(Integer.parseInt(attributs[i].trim()));
        i++;

        dates = attributs[i].split(",");

        session.setDateDebut(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
        i++;

        dates = attributs[i].split(",");

        session.setDateFin(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
        return session;
    }


    // Tests pour la fonctionnalité 1 - verifierCoursSessionEnCours
    @Test
    public void testVerifierCoursSessionEnCours_CoursExistant_ReturnsTrue() {
        assertTrue("INF1070 devrait se donner dans la session courante",
                groupesCours.verifierCoursSessionEnCours("INF1070"));
    }

    @Test
    public void testVerifierCoursSessionEnCours_CoursSessionPassee_ReturnsFalse() {
        assertFalse("MAT4681 ne devrait pas se donner dans la session courante",
                groupesCours.verifierCoursSessionEnCours("MAT4681"));
    }

    @Test
    public void testVerifierCoursSessionEnCours_CoursInexistant_ReturnsFalse() {
        assertFalse("Un cours inexistant ne devrait pas être trouvé",
                groupesCours.verifierCoursSessionEnCours("INEXISTANT"));
    }

    @Test
    public void testVerifierCoursSessionEnCours_SigleNull_ReturnsFalse() {
        assertFalse("Sigle null devrait retourner false",
                groupesCours.verifierCoursSessionEnCours(null));
    }

    @Test
    public void testVerifierCoursSessionEnCours_SigleVide_ReturnsFalse() {
        assertFalse("Sigle vide devrait retourner false",
                groupesCours.verifierCoursSessionEnCours(""));
    }

    // Tests pour la fonctionnalité 2 - getCourseProgrammeSessionEnCours
    @Test
    public void testGetCourseProgrammeSessionEnCours_ProgrammeExistant_ReturnsCorrectList() {
        List<Cours> result = groupesCours.getCourseProgrammeSessionEnCours(123);

        assertNotNull("La liste ne devrait pas être null", result);
        assertEquals("Le programme 123 devrait avoir 1 cours", 1, result.size());
        assertEquals("Le cours devrait être INF1070", "INF1070", result.get(0).getSigle());
    }

    @Test
    public void testGetCourseProgrammeSessionEnCours_ProgrammeInexistant_ReturnsEmptyList() {
        List<Cours> result = groupesCours.getCourseProgrammeSessionEnCours(999);

        assertNotNull("La liste ne devrait pas être null", result);
        assertTrue("La liste devrait être vide", result.isEmpty());
    }

    @Test
    public void testGetCourseProgrammeSessionEnCours_CodeNull_ReturnsEmptyList() {
        List<Cours> result = groupesCours.getCourseProgrammeSessionEnCours(null);

        assertNotNull("La liste ne devrait pas être null", result);
        assertTrue("La liste devrait être vide pour code null", result.isEmpty());
    }

    @Test
    public void testAssertionsDiverses() {
        Object a = new Object();
        Object b = new Object();
        Object c = a;

        assertNotNull("Objet ne doit pas être null", a);
        assertSame("Références identiques", a, c);
        assertNotSame("Références différentes", a, b);
        assertTrue("Doit être vrai", 5 > 2);
        assertFalse("Doit être faux", 2 > 5);
        assertNotEquals("Valeurs différentes", 10, 5);
        assertArrayEquals("Tableaux identiques", new int[]{1, 2}, new int[]{1, 2});
    }

    // S'exécute APRÈS chaque méthode de test
    @After
    public void tearDown() {
        //Fermeture du fichier

        try {
            fluxTampon.close();
            fluxConnecteur.close();
        }  catch (IOException e) {
            System.out.println ("Erreur d'entrée / sortie");
        }

        //Destruction des listes
        etudiants = new EtudiantImpl();
        cours = new CoursImpl();
        enseignants = new EnseignantImpl();
        groupesCours = new GroupeCoursImpl();
        inscriptions = new InscriptionImpl();
        sessions = new SessionImpl();
    }

    // S'exécute UNE FOIS après tous les tests
    @AfterClass
    public static void tearDownAfterClass() {
        File file;

        file = new File("EtudiantsTest.csv");
        file.delete();

        file = new File("CoursTest.csv");
        file.delete();

        file = new File("EnseignantsTest.csv");
        file.delete();

        file = new File("SessionsTest.csv");
        file.delete();

        file = new File("GroupesCoursTest.csv");
        file.delete();

        file = new File("InscriptionsTest.csv");
        file.delete();
    }


}