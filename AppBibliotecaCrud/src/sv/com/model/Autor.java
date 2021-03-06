package sv.com.model;
// Generated 04.02.2018 20:26:54 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Autor generated by hbm2java
 */
public class Autor implements java.io.Serializable {

	private Integer idAutor;
	private Pais pais;
	private String nombresAutor;
	private String apellidosAutor;
	private Set<Libro> libros = new HashSet<Libro>(0);

	public Autor() {
		this.pais = new Pais();
	}

	public Autor(Pais pais, String nombresAutor, String apellidosAutor) {
		this.pais = pais;
		this.nombresAutor = nombresAutor;
		this.apellidosAutor = apellidosAutor;
	}

	public Autor(Pais pais, String nombresAutor, String apellidosAutor, Set<Libro> libros) {
		this.pais = pais;
		this.nombresAutor = nombresAutor;
		this.apellidosAutor = apellidosAutor;
		this.libros = libros;
	}

	public Integer getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombresAutor() {
		return this.nombresAutor;
	}

	public void setNombresAutor(String nombresAutor) {
		this.nombresAutor = nombresAutor;
	}

	public String getApellidosAutor() {
		return this.apellidosAutor;
	}

	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}

	public Set<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

}
