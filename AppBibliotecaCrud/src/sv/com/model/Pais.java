package sv.com.model;
// Generated 04.02.2018 20:26:54 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Pais generated by hbm2java
 */
public class Pais implements java.io.Serializable {

	private Integer idPais;
	private String nombrePais;
	private Set<Autor> autors = new HashSet<Autor>(0);
	private Set<Editorial> editorials = new HashSet<Editorial>(0);

	public Pais() {
	}

	public Pais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Pais(String nombrePais, Set<Autor> autors, Set<Editorial> editorials) {
		this.nombrePais = nombrePais;
		this.autors = autors;
		this.editorials = editorials;
	}

	public Integer getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Set<Autor> getAutors() {
		return this.autors;
	}

	public void setAutors(Set<Autor> autors) {
		this.autors = autors;
	}

	public Set<Editorial> getEditorials() {
		return this.editorials;
	}

	public void setEditorials(Set<Editorial> editorials) {
		this.editorials = editorials;
	}

}
