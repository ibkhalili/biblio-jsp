package ma.ensak.beans;

import java.util.Date;

public class Livre {

	private Number numero;
	private String titre;
	private String numero_edition;
	private Date date_apparition;
	private Number stock;

	public Livre(Number numero, String titre, String numero_edition, Date date_apparition, Number stock) {
		super();
		this.numero = numero;
		this.titre = titre;
		this.numero_edition = numero_edition;
		this.date_apparition = date_apparition;
		this.stock = stock;
	}

	public Livre() {
		// TODO Auto-generated constructor stub
	}

	public String getTitre() {
		return titre;
	}
	public String getNumero_edition() {
		return numero_edition;
	}
	public Date getDate_apparition() {
		return date_apparition;
	}
	public Number getStock() {
		return stock;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setNumero_edition(String numero_edition) {
		this.numero_edition = numero_edition;
	}
	public void setDate_apparition(Date date_apparition) {
		this.date_apparition = date_apparition;
	}
	public void setStock(Number stock) {
		this.stock = stock;
	}
	public Number getNumero() {
		return numero;
	}
	public void setNumero(Number numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return numero + ", " + titre + ", " + numero_edition
				+ ", " + date_apparition + ", " + stock;
	}
	
}
