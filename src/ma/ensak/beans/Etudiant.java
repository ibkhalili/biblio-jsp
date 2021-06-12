package ma.ensak.beans;

public class Etudiant {

	private String nom;
	private String prenom;
	private String filiere;
	private String cin;

	public Etudiant(String nom, String prenom, String filiere, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.cin = cin;
	}
	
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public String getCin() {
		return cin;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}

	@Override
	public String toString() {
		return nom + ", " + prenom + ", " + filiere + ", " + cin;
	}
	
	

}
