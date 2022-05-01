package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.UsuarioBusiness;
import org.example.entities.Usuario;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBusiness usuarioBusiness;

	private Usuario usuario;
	private Usuario usuarioSelected;
	private List<Usuario> usuarios;

	private String filCorreo;
	private String filPassword;
	private String filterName;

	@PostConstruct
	public void init() {

		usuario = new Usuario();
		usuarioSelected = new Usuario();
		usuarios = new ArrayList<>();

	}

	public void mostrarUsuario() {
		try {
			usuarios = usuarioBusiness.listarUsuario();
		} catch (Exception e) {
		}
	}

	public void seleccionarUsuario(SelectEvent e) {
		this.usuarioSelected = (Usuario) e.getObject();
	}

	public String nuevoUsuario() {
		this.limpiarFormulario();
		return "insert.xhtml";
	}

	public String editarUsuario() {
		String view = "";
		try {
			if (this.usuarioSelected != null) {
				this.usuario = usuarioSelected;
				view = "/usuario/update";
			} else {
				Message.messageInfo("Debe seleccionar");
			}

		} catch (Exception e) {
			Message.messageError("Error" + e.getMessage());
		}

		return view;
	}

	public String guardarUsuario() {
		String view = "";
		try {
			if (usuario.getcUsuario() != null) {// update
				usuarioBusiness.update(usuario);
				Message.messageInfo("Registro actualizado exitosamente");
				this.limpiarFormulario();
				view = "/usuario/list";
			} else {// save
				usuarioBusiness.insert(usuario);
				Message.messageInfo("Registro guardado exitosamente");
				this.limpiarFormulario();
				view = "/usuario/login";
			}

		} catch (Exception e) {
			Message.messageError("Error ProductController:" + e.getMessage());
		}

		/*
		 * try { usuarioBusiness.insert(usuario);
		 * Message.messageInfo("Registro exitoso"); mostrarUsuario();
		 * limpiarFormulario(); view = "/usuario/list"; } catch (Exception e) {
		 * Message.messageInfo("Error al registrar" + e.getMessage()); }
		 */
		return view;
	}

	public void buscarPorNombre() {
		try {
			usuarios = usuarioBusiness.getFindName(filterName);
			limpiarFormulario();

			if (usuarios.isEmpty()) {
				Message.messageInfo("No se encontraron usuarios con dicho nombre");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String verificarLogin() {
		String view = "";
		try {
			usuarios = usuarioBusiness.getFindLogin(filCorreo, filPassword);
			limpiarFormulario();

			if (usuarios.isEmpty()) {
				Message.messageInfo("No se encuentra registrado");
				view = "/usuario/login";
			} else {
				view = "/usuario/list";
			}

		} catch (Exception e) {
		}
		return view;
	}

	public String loginUsuario() {
		return "/usuario/login";
	}

	public String regresarLogin() {
		return "/usuario/login";
	}

	public String regresarLista() {
		return "/usuario/list";
	}

	public void limpiarFormulario() {
		usuario = new Usuario();
	}

	public String vacio() {
		return "";
	}

	//////////////////////////////////
	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelected() {
		return usuarioSelected;
	}

	public void setUsuarioSelected(Usuario usuarioSelected) {
		this.usuarioSelected = usuarioSelected;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getFilCorreo() {
		return filCorreo;
	}

	public void setFilCorreo(String filCorreo) {
		this.filCorreo = filCorreo;
	}

	public String getFilPassword() {
		return filPassword;
	}

	public void setFilPassword(String filPassword) {
		this.filPassword = filPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
