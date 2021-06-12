package ma.ensak.beans;

import java.util.Date;

public class Emprunt {

	private Number numero;
	private Number numero_livre;
	private String cin_etudiant;
	private Date date;
	private Date remis_le;

	public Emprunt(Number numero_livre, String cin_etudiant, Date date) {
		super();
		this.numero_livre = numero_livre;
		this.cin_etudiant = cin_etudiant;
		this.date = date;
	}

	public Emprunt() {
		// TODO Auto-generated constructor stub
	}

	public Number getNumero_livre() {
		return numero_livre;
	}
	public String getCin_etudiant() {
		return cin_etudiant;
	}
	public Date getDate() {
		return date;
	}
	public void setNumero_livre(Number numero_livre) {
		this.numero_livre = numero_livre;
	}
	public void setCin_etudiant(String cin_etudiant) {
		this.cin_etudiant = cin_etudiant;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getRemis_le() {
		return remis_le;
	}
	public void setRemis_le(Date remis_le) {
		this.remis_le = remis_le;
	}
	public Number getNumero() {
		return numero;
	}
	public void setNumero(Number numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return numero + ", " + numero_livre + ", " + cin_etudiant
				+ ", " + date + ", " + remis_le;
	}

}
