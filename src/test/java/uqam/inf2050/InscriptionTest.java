package uqam.inf2050;

import org.junit.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class InscriptionTest {

    private InscriptionImpl inscriptionImpl;

    // S'exécute UNE FOIS avant tous les tests
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Début des tests unitaires...");
    }

    // S'exécute UNE FOIS après tous les tests
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Fin des tests unitaires.");
    }

    // S'exécute AVANT chaque méthode de test
    @Before
    public void setUp() {
        inscriptionImpl = new InscriptionImpl();
    }

    // S'exécute APRÈS chaque méthode de test
    @After
    public void tearDown() {
        System.out.println("Test terminé.");
    }

    @Test
    public void testGetProgrammePourcentageEleveSessionEnCours_NoInscriptions_ReturnsNull() {
        assertNull("Doit retourner null s'il n'y a aucune inscription.",
                inscriptionImpl.getProgrammePourcentageEleveSessionEnCours());
    }

    @Test
    public void testGetProgrammePourcentageEleveSessionEnCours_WithInscriptions_ReturnsCorrectProgramme() {
        // Création d'une session en cours
        Session session = new Session();
        session.setCodeSession(1);
        session.setDateDebut(LocalDate.now().minusDays(1));
        session.setDateFin(LocalDate.now().plusDays(1));

        // Cours et groupe
        Cours cours = new Cours();
        cours.setSigle("INF101");

        GroupeCours groupe = new GroupeCours();
        groupe.setCours(cours);
        groupe.setSession(session);
        groupe.setMaxInscription(2);  // Max: 2 étudiants

        // Étudiants
        Etudiant e1 = new Etudiant(); e1.setCodeProgramme(100);
        Etudiant e2 = new Etudiant(); e2.setCodeProgramme(100);

        // Inscriptions
        Inscription i1 = new Inscription(); i1.setEtudiant(e1); i1.setGroupe(groupe); i1.setDateInscription(LocalDate.now());
        Inscription i2 = new Inscription(); i2.setEtudiant(e2); i2.setGroupe(groupe); i2.setDateInscription(LocalDate.now());

        // Ajouter inscriptions
        inscriptionImpl.addInscription(i1);
        inscriptionImpl.addInscription(i2);

        // Test : taux = 2/2 = 1.0 → programme 100
        Number result = inscriptionImpl.getProgrammePourcentageEleveSessionEnCours();
        assertNotNull(result);
        assertEquals(100, result);
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

    @Test(expected = ArithmeticException.class)
    public void testDivisionParZero_ErreurAttendue() {
        int x = 1 / 0; // Devrait lancer ArithmeticException
    }
}
