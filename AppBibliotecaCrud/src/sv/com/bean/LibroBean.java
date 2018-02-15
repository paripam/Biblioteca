package sv.com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sv.com.dao.LibroDao;
import sv.com.impl.LibroDaoImpl;
import sv.com.model.Autor;
import sv.com.model.Categoria;
import sv.com.model.Editorial;
import sv.com.model.Idioma;
import sv.com.model.Libro;

public class LibroBean {
	private List<Libro> listarLibros;
	private Libro libro;

	private List<SelectItem> listEditorial;
	private List<SelectItem> listAutor;
	private List<SelectItem> listIdioma;
	private List<SelectItem> listCategoria;

	public LibroBean() {
		this.libro = new Libro();
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getListarLibros() {
		LibroDao LDao = new LibroDaoImpl();
		listarLibros = LDao.listAllLibros();
		return listarLibros;
	}

	public List<SelectItem> getListEditorial() {
		this.listEditorial = new ArrayList<>();
		LibroDao lDao = new LibroDaoImpl();
		List<Editorial> e = lDao.listAllEditoriales();
		listEditorial.clear();
		for (Editorial editorial : e) {
			SelectItem editorialItem = new SelectItem(editorial.getIdEditorial(), editorial.getNombreEditorial());
			this.listEditorial.add(editorialItem);
		}
		return listEditorial;
	}

	public List<SelectItem> getListAutor() {
		this.listAutor = new ArrayList<>();
		LibroDao lDao = new LibroDaoImpl();
		List<Autor> a = lDao.listAllAutores();
		listAutor.clear();
		for (Autor autor : a) {
			SelectItem autorItem = new SelectItem(autor.getIdAutor(),
					autor.getNombresAutor() + " " + autor.getApellidosAutor());
			this.listAutor.add(autorItem);
		}
		return listAutor;
	}

	public List<SelectItem> getListIdioma() {
		this.listIdioma = new ArrayList<>();
		LibroDao lDao = new LibroDaoImpl();
		List<Idioma> i = lDao.listAllIdiomas();
		listIdioma.clear();
		for (Idioma idioma : i) {
			SelectItem idiomaItem = new SelectItem(idioma.getIdIdioma(), idioma.getIdioma());
			this.listIdioma.add(idiomaItem);
		}
		return listIdioma;
	}

	public List<SelectItem> getListCategoria() {
		this.listCategoria = new ArrayList<>();
		LibroDao lDao = new LibroDaoImpl();
		List<Categoria> c = lDao.listAllCategorias();
		listCategoria.clear();
		for (Categoria categoria : c) {
			SelectItem categoriaItem = new SelectItem(categoria.getIdCategoria(), categoria.getNombreCategoria());
			this.listCategoria.add(categoriaItem);
		}
		return listCategoria;
	}

	public void prepararNuevoRegistro() {
		this.libro = new Libro();
	}

	public void nuevoLibro() {
		LibroDao lDao = new LibroDaoImpl();
		lDao.newLibro(libro);
	}
	public void editarLibro(){
		LibroDao lDao = new LibroDaoImpl();
		lDao.updateLibro(libro);
		this.libro = new Libro();
	}
	public void deleteLibro(){
		LibroDao lDao = new LibroDaoImpl();
		lDao.deleteLibro(libro);
		this.libro = new Libro();
	}

	public static void main(String[] args) {
		LibroBean bean = new LibroBean();
		
	}
}
