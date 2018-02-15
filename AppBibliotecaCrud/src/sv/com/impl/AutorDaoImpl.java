package sv.com.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sv.com.dao.AutorDao;
import sv.com.model.Autor;
import sv.com.model.Pais;
import sv.com.util.HibernateUtil;

public class AutorDaoImpl implements AutorDao {
	Session s=null;

	@Override
	public void nuevoAutor(Autor autor) {
		s = HibernateUtil.getSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			s.save(autor);
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
	public void editarAutor(Autor autor) {
		s = HibernateUtil.getSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			s.update(autor);
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
	public void eliminarAutor(Autor autor) {
		s = HibernateUtil.getSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			s.delete(autor);
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
	public List<Autor> listarAutores() {
		List<Autor> listaDeAutores = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Autor a INNER JOIN FETCH a.pais";
		try {
			listaDeAutores = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
		}
		return listaDeAutores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> listarPaises() {
		List<Pais> listaDePaises = null;
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		String hql = "FROM Pais";
		try {
			listaDePaises = s.createQuery(hql).list();
			t.commit();
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			t.rollback();
		}
		return listaDePaises;
	}

}
