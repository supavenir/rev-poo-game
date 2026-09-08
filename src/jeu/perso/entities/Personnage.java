package jeu.perso.entities;

import java.util.ArrayList;
import java.util.List;

public class Personnage {
	private String nom;
	private int pointDevie;
	private int maxPointDevie=15;
	private List<Fiole> sac;
	
	public Personnage() {
		this.sac = new ArrayList<Fiole>();
	}
	
	public void saluer() {
		System.out.println("Bonjour, je suis "+nom);
	}
	
	public void prendre(Fiole fiole) {
		sac.add(fiole);
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getPointDevie() {
		return this.pointDevie;
	}
	
	public void boire(Fiole fiole,boolean force) {
		if(force) {
			pointDevie+=fiole.getPointDeVie();
			fiole.setPointDeVie(0);
		}
	}
}
