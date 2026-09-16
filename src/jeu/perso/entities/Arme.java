package jeu.perso.entities;

public class Arme extends Objet {

	private int degats;

	public Arme() {
		this("Arme de base", 1);
	}

	public Arme(String nom, int degats) {
		super(nom);
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public void utiliser(Personnage personnage) {
		personnage.subirDegats(degats);
	}

	@Override
	public String toString() {
		return "Arme infligeant " + degats + " dégats";
	}
}
