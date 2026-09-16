package jeu.perso;

import jeu.perso.entities.Arme;
import jeu.perso.entities.Fiole;
import jeu.perso.entities.Personnage;

public class ProgJeu {
	public static void main(String[] args) {

		Personnage.maxPointDevie = 20;

		Personnage p = new Personnage();
		p.saluer();
		p.prendre(new Fiole());
		p.boire();
		Fiole f = new Fiole();
		f.setPointDeVie(10);
		p.boire(f, false);
		System.out.println(p.getPointDevie());
		p.prendre(new Arme());
		System.out.println(p.getSac());
	}
}
