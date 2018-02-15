package sv.com.dao;

import java.util.List;

import sv.com.model.Autor;
import sv.com.model.Pais;

public interface AutorDao {
	public void nuevoAutor(Autor autor);
	public void editarAutor(Autor autor);
	public void eliminarAutor(Autor autor);
	public List<Autor> listarAutores();
	public List<Pais> listarPaises();
}
