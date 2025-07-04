package test.java.uqam.inf2050;

//Librairies File
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

//Librairies jUnit
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class CoursTest {

    @BeforeClass
    public static void setUpClass() {
        try {
            PrintWriter pWriter;

            //Setup des etudiants
            pWriter = new PrintWriter((new FileWriter("EtudiantsTest.csv")));
            pWriter.println("Code Permanent;Nom;Prenom;Code Programme");
            pWriter.println("ANDA12345;Andrews;Archie;123");
            pWriter.println("VASA65432;Vasquez;Alexandra;456");
            pWriter.println("FRYP78910;Fry;Philip;789");
            pWriter.println("BLAD11121;Blake;Daphne;123");
            pWriter.close();

            //Setup des cours
            pWriter = new PrintWriter((new FileWriter("CoursTest.csv")));
            pWriter.println("Sigle;Titre;Description;Nombre Credits");
            pWriter.println("INF1070;Linux;Man moi ca;1");
            pWriter.println("MAT4681;Statistiques;Probablement probabiliste;2");
            pWriter.println("INF1132;Math Info;Never forget;3");
            pWriter.println("INF2171;Assembleur;Tout n'est que bits;4");
            pWriter.close();

            //Setup des enseignants
            pWriter = new PrintWriter((new FileWriter("EnseignantsTest.csv")));
            pWriter.println("Code d'enseignant;Nom;Prenom");
            pWriter.println("1111;Poulin;Julien");
            pWriter.println("2222;Martin;Pauline");
            pWriter.println("3333;Lebeau;Pierre");
            pWriter.println("4444;Di Stasio;Josee");
            pWriter.close();

        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
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
    }
}
