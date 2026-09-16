package jeu.perso.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.perso.entities.Arme;
import jeu.perso.entities.Fiole;
import jeu.perso.entities.Personnage;

class PersonnageTest {
	private Personnage personnage;
	private Fiole fiole;

	@BeforeEach
	void setUp() throws Exception {
		Personnage.maxPointDevie = 10;
		personnage = new Personnage();
		fiole = new Fiole();
		fiole.setPointDeVie(5);
	}

	@Test
	void testPrendre() {
		fail("Not yet implemented");
	}

	@Test
	void testBoire() {
		fail("Not yet implemented");
	}

	@Test
	void testBoireInt() {
		fail("Not yet implemented");
	}

	@Test
	void testBoireFioleBoolean() {
		// Cas : Personnage boit en force une fiole dont il n'a pas besoin
		assertEquals(10, personnage.getPointDevie());
		personnage.boire(fiole, true);
		assertEquals(10, personnage.getPointDevie());
		assertEquals(0, fiole.getPointDeVie());
	}

	@Test
	void attaquerTest() {
		Personnage autre = new Personnage();
		Arme epee = new Arme("Epée", 5);
		Arme lanceFlammes = new Arme("Lance Flammes", 30);
		assertEquals(10, autre.getPointDevie());
		assertTrue(autre.estVivant());
		personnage.attaquer(autre, epee);
		assertEquals(5, autre.getPointDevie());
		assertTrue(autre.estVivant());
		// 2ème attaque => mort
		personnage.attaquer(autre, epee);
		assertEquals(0, autre.getPointDevie());
		assertFalse(autre.estVivant());

		// Recréation du personnage
		autre = new Personnage();
		assertEquals(10, autre.getPointDevie());
		assertTrue(autre.estVivant());

		personnage.attaquer(autre, lanceFlammes);
		assertEquals(0, autre.getPointDevie());
		assertFalse(autre.estVivant());
	}

}
