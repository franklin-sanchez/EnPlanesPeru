package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Usuario;

@Named
public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long insert(Usuario usuario) throws Exception {
		em.persist(usuario);
		return usuario.getcUsuario();
	}

	public Long update(Usuario usuario) throws Exception {
		em.merge(usuario);
		return usuario.getcUsuario();
	}

	public List<Usuario> findAll() throws Exception {
		List<Usuario> usuarios = new ArrayList<>();
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u", Usuario.class);
		usuarios = query.getResultList();
		return usuarios;
	}
	
	public List<Usuario> findName(String nombre)  throws Exception{
		List<Usuario> usuarios=new ArrayList<>();
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u WHERE u.nUsuarioNombre LIKE ?1", Usuario.class);
		query.setParameter(1, "%"+nombre+"%");
		usuarios=query.getResultList();		
		return usuarios;
	}
	public List<Usuario> findLogin(String correo,String contra)  throws Exception{
		List<Usuario> usuarios=new ArrayList<>();
		TypedQuery<Usuario> query=em.createQuery("FROM Usuario u WHERE u.tCorreo=?1 and u.tPassword=?2", Usuario.class);
		query.setParameter(1, correo);
		query.setParameter(2, contra);
		usuarios=query.getResultList();		
		return usuarios;
	}
}
