package org.example.business;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Afiliado;
import org.example.repository.AfiliadoRepository;

@Named
public class AfiliadoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AfiliadoRepository afiliadoRepository;

	@Transactional
	public Long insert(Afiliado afiliado) throws Exception {
		return afiliadoRepository.insert(afiliado);
	}

	@Transactional
	public Long update(Afiliado afiliado) throws Exception {
		return afiliadoRepository.update(afiliado);
	}

	public List<Afiliado> listarAfiliado() throws Exception {
		return afiliadoRepository.findAll();
	}

	public List<Afiliado> getFindLogin(String correo, String contra) throws Exception {
		return afiliadoRepository.findLogin(correo, contra);
	}
}
