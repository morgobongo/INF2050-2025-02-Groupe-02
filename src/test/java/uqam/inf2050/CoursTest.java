package uqam.inf2050;

//Librairies File
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;

//Librairies jUnit
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class CoursTest {

    static EtudiantImpl etudiants = new EtudiantImpl();
    static CoursImpl cours = new CoursImpl();
    static EnseignantImpl enseignants = new EnseignantImpl();
    static SessionImpl sessions = new SessionImpl();
    static GroupeCoursImpl groupesCours = new GroupeCoursImpl();
    static InscriptionImpl inscriptions = new InscriptionImpl();

    static FileReader fluxConnecteur;
    static BufferedReader fluxTampon;

    @BeforeClass
    public static void setUpClass() {
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

            pWriter.println("INF1070;1111;H2024;25;R111");
            pWriter.println("INF2171;4444;H2024;20;R222");

            pWriter.println("MAT4681;2222;A2024;15;S111");

            pWriter.println("INF1132;3333;E2024;30;S222");

            pWriter.println("INF2171;4444;H2025;35;T111");

            pWriter.println("INF1070;3333;A2025;23;T222");
            pWriter.println("INF2171;1111;A2025;19;U111");

            pWriter.println("MAT4681;2222;E2025;32;U222");
            pWriter.close();

            //Setup des inscriptions
            pWriter = new PrintWriter((new PrintWriter("InscriptionsTest.csv")));
            pWriter.println("Etudiant;GroupeCours;Date d'inscription;Date d'abandon;Note");

            pWriter.println("ANDA12345;INF1070,1111;2024,1,1;2024,3,1;50");
            pWriter.println("VASA65432;INF1070,1111;2024,1,2;2024,3,2;52");
            pWriter.println("FRYP78910;INF1070,1111;2024,1,3;2024,3,3;54");

            pWriter.println("VASA65432;INF2171,4444;2024,1,2;2024,2,1;60");
            pWriter.println("ANDA12345;INF2171,4444;2024,1,1;2024,3,2;62");
            pWriter.println("BLAD11121;INF2171,4444;2024,1,4;2024,3,3;64");
            pWriter.println("FRYP78910;INF2171,4444;2024,1,3;2024,3,4;66");

            pWriter.println("FRYP78910;MAT4681,2222;2024,9,1;2024,10,1;70");
            pWriter.println("ANDA12345;MAT4681,2222;2024,9,2;2024,10,2;72");

            pWriter.println("BLAD11121;INF1132,3333;2024,6,1;2024,7,1;80");
            pWriter.println("VASA65432;INF1132,3333;2024,6,2;2024,7,2;82");

            pWriter.println("ANDA12345;INF21714444;2025,1,1;2025,3,1;90");
            pWriter.println("BLAD11121;INF21714444;2025,1,2;2025,3,2;92");
            pWriter.println("VASA65432;INF21714444;2025,1,3;2025,3,3;94");

            pWriter.println("VASA65432;INF1070,3333;2025,9,1;2024,10,1;40");
            pWriter.println("FRYP78910;INF1070,3333;2025,9,2;2024,10,2;42");

            pWriter.println("ANDA12345;INF2171,1111;2025,9,1;2024,10,1;30");
            pWriter.println("FRYP78910;INF2171,1111;2025,9,2;2024,10,2;32");

            pWriter.println("VASA65432;MAT4681,2222;2025,6,1;2025,7,1;20");
            pWriter.println("ANDA12345;MAT4681,2222;2025,6,2;2025,7,2;22");
            pWriter.println("FRYP78910;MAT4681,2222;2025,6,3;2025,7,3;24");
            pWriter.println("BLAD11121;MAT4681,2222;2025,6,4;2025,7,4;26");
            pWriter.close();

        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
    }

    @Before
    public void setUp() {
        //Déclaration des variables
        String uneLigne;
        String[] attributs;

        try {
            //Creation etudiants
            fluxConnecteur = new FileReader ("EtudiantsTest.csv");
            fluxTampon = new BufferedReader (fluxConnecteur);
            fluxTampon.readLine();
            Etudiant etudiant = new Etudiant();

            while (fluxTampon.ready()) {
                //Découpage de la ligne du fichier csv
                uneLigne = fluxTampon.readLine();
                attributs = uneLigne.split(";");

                //Création du tableau selon les données du fichier
                if (attributs.length == 4) {
                    //Récupération des informations
                    byte i = 0;

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

                //Creation cours
                fluxConnecteur = new FileReader("CoursTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();
                Cours cour = new Cours();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 4) {
                        //Récupération des informations
                        byte i = 0;

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
                Enseignant enseignant = new Enseignant();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 3) {
                        //Récupération des informations
                        byte i = 0;

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
                Session session = new Session();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 3) {
                        //Récupération des informations
                        byte i = 0;
                        String[] dates;

                        session.setCodeSession(Integer.parseInt(attributs[i].trim()));
                        i++;

                        dates = attributs[i].split(",");

                        session.setDateDebut(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
                        i++;

                        dates = attributs[i].split(",");

                        session.setDateFin(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));

                        //Attribution a la liste
                        sessions.addSession(session);

                    } else {
                        System.out.println("Données incomplètes");
                    }
                }

                //Creation groupes cours
                fluxConnecteur = new FileReader("GroupeCoursTest.csv");
                fluxTampon = new BufferedReader(fluxConnecteur);
                fluxTampon.readLine();
                GroupeCours groupeCours = new GroupeCours();

                while (fluxTampon.ready()) {
                    //Découpage de la ligne du fichier csv
                    uneLigne = fluxTampon.readLine();
                    attributs = uneLigne.split(";");

                    //Création du tableau selon les données du fichier
                    if (attributs.length == 5) {
                        //Récupération des informations
                        byte i = 0;

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
                Inscription inscription = new Inscription();

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

                        inscription.setEtudiant(etudiants.getEtudiant(attributs[i].trim()));
                        i++;

                        groupeCoursInsc = attributs[i].split(",");
                        inscription.setGroupe(groupesCours.getGroupeCours(groupeCoursInsc[0],enseignants.getEnseignant(groupeCoursInsc[1])));
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
            }
        } catch (FileNotFoundException e) {
            System.out.println ("Erreur: Fichier non trouvé");
        } catch (IOException e) {
            System.out.println ("Erreur d'entrée / sortie");
        } catch (NumberFormatException e) {
            System.out.println("Format invalide de donnée");
        }
    }

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

    @AfterClass
    public static void tearDownClass() {
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
