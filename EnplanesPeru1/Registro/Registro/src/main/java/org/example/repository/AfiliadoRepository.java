package org.example.repository;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Afiliado;

@Named
public class AfiliadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long insert(Afiliado afiliado) throws Exception {
		em.persist(afiliado);
		return afiliado.getcAfiliado();
	}

	public Long update(Afiliado afiliado) throws Exception {
		em.merge(afiliado);
		return afiliado.getcAfiliado();
	}

	public List<Afiliado> findAll() throws Exception {
		List<Afiliado> afiliados = new ArrayList<>();
		TypedQuery<Afiliado> query = em.createQuery("FROM Afiliado a", Afiliado.class);
		afiliados = query.getResultList();
		return afiliados;
	}
	public List<Afiliado> findLogin(String correo,String contra)  throws Exception{
		List<Afiliado> afiliados=new ArrayList<>();
		TypedQuery<Afiliado> query=em.createQuery("FROM Afiliado a WHERE a.tCorreo=?1 and a.tPassword=?2", Afiliado.class);
		query.setParameter(1, correo);
		query.setParameter(2, contra);
		afiliados=query.getResultList();		
		return afiliados;
	}
}