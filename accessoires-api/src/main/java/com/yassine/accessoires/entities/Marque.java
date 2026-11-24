package com.yassine.accessoires.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Marque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarque;

	private String nomMarque;

	private String descriptionMarque;

	@OneToMany(mappedBy = "marque")
	@JsonIgnore
	private List<Accessoire> accessoires;

	public Marque() {
		super();
	}

	public Marque(Long idMarque, String nomMarque, String descriptionMarque) {
		super();
		this.idMarque = idMarque;
		this.nomMarque = nomMarque;
		this.descriptionMarque = descriptionMarque;
	}

	public Long getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public String getDescriptionMarque() {
		return descriptionMarque;
	}

	public void setDescriptionMarque(String descriptionMarque) {
		this.descriptionMarque = descriptionMarque;
	}

	public List<Accessoire> getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}
}
