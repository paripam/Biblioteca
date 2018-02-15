package sv.com.dao;

import java.util.List;

import sv.com.model.Autor;
import sv.com.model.Categoria;
import sv.com.model.Editorial;
import sv.com.model.Idioma;
import sv.com.model.Libro;

public interface LibroDao {
	void newLibro(Libro libro);
	void updateLibro(Libro libro);
	void deleteLibro(Libro libro);
	public List<Libro> listAllLibros();
	
	public List<Editorial> listAllEditoriales();
	public List<Autor> listAllAutores();
	public List<Idioma> listAllIdiomas();
	public List<Categoria> listAllCategorias();
}
