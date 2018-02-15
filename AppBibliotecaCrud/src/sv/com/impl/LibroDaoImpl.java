package sv.com.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sv.com.dao.LibroDao;
import sv.com.model.Autor;
import sv.com.model.Categoria;
import sv.com.model.Editorial;
import sv.com.model.Idioma;
import sv.com.model.Libro;
import sv.com.util.HibernateUtil;

public class LibroDaoImpl implements LibroDao {
	Session s =null;

	@Override
	public void newLibro(Libro libro) {
		s = HibernateUtil.getSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			s.save(libro);
			s.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

	

	@Override
	public void updateLibro(Libro libro) {
		s = HibernateUtil.getSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			s.update(libro);
			s.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

	@Override
	public void deleteLibro(Libro libro) {
		s = HibernateUtil.getSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			s.delete(libro);
			s.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> listAllLibros() {
		List<Libro> listaLibros = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Libro lb INNER JOIN FETCH lb.editorial LEFT JOIN FETCH lb.autor LEFT JOIN FETCH lb.idioma LEFT JOIN FETCH lb.categoria";
		try {
			listaLibros = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			t.rollback();
		}
		return listaLibros;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Editorial> listAllEditoriales() {
		List<Editorial> listaEditoriales = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Editorial";
		try {
			listaEditoriales = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			t.rollback();
		}
		return listaEditoriales;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Autor> listAllAutores() {
		List<Autor> listaAutores = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Autor";
		try {
			listaAutores = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			t.rollback();
		}
		return listaAutores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Idioma> listAllIdiomas() {
		List<Idioma> listaIdiomas = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Idioma";
		try {
			listaIdiomas = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			t.rollback();
		}
		return listaIdiomas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listAllCategorias() {
		List<Categoria> listaCategorias = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Categoria";
		try {
			listaCategorias = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			t.rollback();
		}
		return listaCategorias;
	}

}
