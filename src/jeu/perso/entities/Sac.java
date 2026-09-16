package jeu.perso.entities;

import java.util.ArrayList;
import java.util.List;

public class Sac {
	private List<Objet> objets;

	public Sac() {
		objets = new ArrayList<Objet>();
	}

	public void ajouter(Objet o) {
		objets.add(o);
	}

	@Override
	public String toString() {
		return objets.toString();
	}
}
