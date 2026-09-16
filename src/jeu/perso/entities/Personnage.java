package jeu.perso.entities;

public class Personnage {
	private String nom;
	private int pointDevie;
	public static int maxPointDevie = 15;
	private Sac sac;

	public Personnage() {
		this("No name");
	}

	public Personnage(String nom) {
		this(nom, maxPointDevie);
	}

	public Personnage(String nom, int pv) {
		this.sac = new Sac();
		this.pointDevie = pv;
		this.nom = nom;
	}

	public void saluer() {
		System.out.println("Bonjour, je suis " + nom);
	}

	public void prendre(Objet o) {
		sac.ajouter(o);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public Sac getSac() {
		return sac;
	}

	public void attaquer(Personnage autrePerso, Arme arme) {
		arme.utiliser(autrePerso);
	}

	public boolean estVivant() {
		return pointDevie > 0;
	}

	public void subirDegats(int degats) {
		setPointDevie(pointDevie - degats);
	}

	public int getPointDevie() {
		return this.pointDevie;
	}

	/**
	 * Boit un pv à partir d'une fiole de son sac
	 */
	private void setPointDevie(int pointDevie) {
		if (pointDevie < 0) {
			this.pointDevie = 0;
			return;
		}
		if (pointDevie > maxPointDevie) {
			this.pointDevie = maxPointDevie;
			return;
		}
		this.pointDevie = pointDevie;
	}

	/**
	 * Boit un pv à partir d'une fiole de son sac
	 * 
	 * @return vrai si la quantité a été bue
	 */
	public boolean boire() {
		return false;
	}

	/**
	 * Boit une certaine quantité de pv à partir d'une fiole de son sac
	 * 
	 * @param quantite la quantité bue
	 * @return vrai si la quantité a été bue
	 */
	public boolean boire(int quantite) {
		return false;
	}

	/**
	 * Boit une fiole complétement, quelques soient les pointDeVie manquants si
	 * force est true Ne boit que le nécessaire dans le cas contraire, et met la
	 * fiole dans son sac si elle n'est pas vide
	 * 
	 * @param fiole
	 * @param force
	 */
	public void boire(Fiole fiole, boolean force) {
		if (force) {
			int npv = pointDevie + fiole.getPointDeVie();
			setPointDevie(npv);
			fiole.setPointDeVie(0);
		} else {
			int lack = maxPointDevie - pointDevie;
			if (lack > 0) {
				// Il manque des pv au personnage => il va boire
				// Il boit tout si lack est supérieur au nombre de pointDeVie de la fiole
				if (lack > fiole.getPointDeVie()) {
					setPointDevie(pointDevie + fiole.getPointDeVie());
					fiole.setPointDeVie(0);
				} else {
					setPointDevie(maxPointDevie);
					fiole.setPointDeVie(fiole.getPointDeVie() - lack);
					sac.ajouter(fiole);
				}
			} else {
				// Il ne manque aucun pv au personnage
				// il met juste la fiole dans son sac.
				sac.ajouter(fiole);
			}

		}
	}
}