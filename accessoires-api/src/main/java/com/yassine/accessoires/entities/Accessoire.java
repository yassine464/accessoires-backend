package com.yassine.accessoires.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Accessoire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccessoire;

	private String nomAccessoire;

	private Double prixAccessoire;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@ManyToOne
	private Marque marque;

	public Accessoire() {
		super();
	}

	public Accessoire(Long idAccessoire, String nomAccessoire, Double prixAccessoire, Date dateCreation, Marque marque) {
		super();
		this.idAccessoire = idAccessoire;
		this.nomAccessoire = nomAccessoire;
		this.prixAccessoire = prixAccessoire;
		this.dateCreation = dateCreation;
		this.marque = marque;
	}

	public Long getIdAccessoire() {
		return idAccessoire;
	}

	public void setIdAccessoire(Long idAccessoire) {
		this.idAccessoire = idAccessoire;
	}

	public String getNomAccessoire() {
		return nomAccessoire;
	}

	public void setNomAccessoire(String nomAccessoire) {
		this.nomAccessoire = nomAccessoire;
	}

	public Double getPrixAccessoire() {
		return prixAccessoire;
	}

	public void setPrixAccessoire(Double prixAccessoire) {
		this.prixAccessoire = prixAccessoire;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}
}
