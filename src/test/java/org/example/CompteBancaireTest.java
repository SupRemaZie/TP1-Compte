package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CompteBancaireTest {
    static CompteBancaire compteBancaireJohn;
    static CompteBancaire compteBancaireArthur;
    @BeforeAll
    static void setUp() {
        Personne john = new Personne("Doe", "John", "Paris");
        Personne arthur = new Personne("Doe", "Arthur", "Paris");
        compteBancaireJohn = new CompteBancaire(john, 800, 1000);
        compteBancaireArthur = new CompteBancaire(arthur, 800, 1000);
    }

    @BeforeEach
    void setUpEach() {
        compteBancaireJohn.setSold(0);
        compteBancaireArthur.setSold(0);

    }

    /* Test de la fonction crediter */
    @Nested
    class Crediter {
        @Test
        void crediter() {
            compteBancaireJohn.crediter(1000);
            assertEquals(1000, compteBancaireJohn.getSold());
        }
        @Test
        void crediterNegatif() {
            assertThrows(IllegalArgumentException.class, () -> compteBancaireJohn.crediter(-1000));
        }

    }
    /* Test de la fonction debiter */

    @Nested
    class Debiter {
        @Test
        void debiter() {
            compteBancaireJohn.crediter(1000);
            compteBancaireJohn.debiter(500);
            assertEquals(500, compteBancaireJohn.getSold());
        }
        @Test
        void debiterSuperieurAuDebitMax() {

            assertThrows(IllegalArgumentException.class, () -> compteBancaireJohn.debiter(1500));
        }
        @Test
        void debiterDecouvertMaxAtteint() {
            compteBancaireJohn.crediter(1000);
            assertThrows(IllegalArgumentException.class, () -> compteBancaireJohn.debiter(2000));
        }
        @Test
        void debiterNegatif() {
            assertThrows(IllegalArgumentException.class, () -> compteBancaireJohn.debiter(-1000));
        }
    }




    @Test
    void getSold() {
        compteBancaireJohn.crediter(1000);
        assertEquals(1000, compteBancaireJohn.getSold());
    }

    @Test
    void getTitulaire() {
        assertEquals("Doe John Paris", compteBancaireJohn.getTitulaire());
    }


}