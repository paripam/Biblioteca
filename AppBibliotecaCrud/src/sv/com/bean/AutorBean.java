package sv.com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sv.com.dao.AutorDao;
import sv.com.impl.AutorDaoImpl;
import sv.com.model.Autor;
import sv.com.model.Pais;

public class AutorBean {
	private Autor autor;
	private List<Autor> listaAutores;
	private List<SelectItem> listaPaises;
	public AutorBean() {
		this.autor = new Autor();
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Autor> getListaAutores() {
		AutorDao aDao = new AutorDaoImpl();
		listaAutores = aDao.listarAutores();
		return listaAutores;
	}
	public void prepararNuevoRegistro(){
		this.autor = new Autor();
	}
	public void nuevoAutor(){
		AutorDao aDao =new AutorDaoImpl();
		aDao.nuevoAutor(autor);
		this.autor = new Autor();
	}
	public void editarAutor(){
		AutorDao aDao =new AutorDaoImpl();
		aDao.editarAutor(autor);
		this.autor = new Autor();
	}
	public void eliminarAutor(){
		AutorDao aDao =new AutorDaoImpl();
		aDao.eliminarAutor(autor);
		this.autor = new Autor();
	}
	public List<SelectItem> getListaPaises() {
		this.listaPaises = new ArrayList<SelectItem>();
		AutorDao aDao = new AutorDaoImpl();
		List<Pais> p =  aDao.listarPaises();
		listaPaises.clear();
		
		for(Pais pais:p){
			SelectItem paisItem = new SelectItem(pais.getIdPais(), pais.getNombrePais());
			this.listaPaises.add(paisItem);
		}
		return listaPaises;
	}
	
	public static void main(String[] args){
		AutorBean bean = new AutorBean();
		System.out.println(bean.getListaPaises());
	}
	
}
