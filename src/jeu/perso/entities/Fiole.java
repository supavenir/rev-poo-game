package jeu.perso.entities;

public class Fiole extends Objet {

	int pointDeVie;

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	@Override
	public String toString() {
		return "Fiole avec " + pointDeVie + " points de vie";
	}
}
