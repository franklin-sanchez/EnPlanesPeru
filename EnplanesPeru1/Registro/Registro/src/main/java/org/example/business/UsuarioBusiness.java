package org.example.business;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;


import org.example.entities.Usuario;
import org.example.repository.UsuarioRepository;

@Named
public class UsuarioBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Long insert(Usuario usuario) throws Exception {
		return usuarioRepository.insert(usuario);
	}
	
	@Transactional
	public Long update(Usuario usuario) throws Exception {
		return usuarioRepository.update(usuario);
	}
	
	public List<Usuario> listarUsuario() throws Exception {
		return usuarioRepository.findAll();
	}

	public List<Usuario> getFindName(String nombre) throws Exception {
		return usuarioRepository.findName(nombre);
	}
	public List<Usuario> getFindLogin(String correo,String contra) throws Exception {
		return usuarioRepository.findLogin(correo,contra);
	}
}
