package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.AfiliadoBusiness;
import org.example.entities.Afiliado;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class AfiliadoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AfiliadoBusiness afiliadoBusiness;

	private Afiliado afiliado;
	private Afiliado afiliadoSelected;
	private List<Afiliado> afiliados;

	private String filCorreo;
	private String filPassword;

	@PostConstruct
	public void init() {

		afiliado = new Afiliado();
		afiliadoSelected = new Afiliado();
		afiliados = new ArrayList<>();

	}

	public void mostrarAfiliado() {
		try {
			afiliados = afiliadoBusiness.listarAfiliado();
		} catch (Exception e) {
		}
	}

	public void seleccionarAfiliado(SelectEvent e) {
		this.afiliadoSelected = (Afiliado) e.getObject();
	}

	public String nuevoAfiliado() {
		this.limpiarFormulario();
		return "/afiliado/insert.xhtml";
	}

	public String editarAfiliado() {
		String view = "";
		try {
			if (this.afiliadoSelected != null) {
				this.afiliado = afiliadoSelected;
				view = "/afiliado/update";
			} else {
				Message.messageInfo("Debe seleccionar");
			}

		} catch (Exception e) {
			Message.messageError("Error" + e.getMessage());
		}

		return view;
	}

	public String guardarAfiliado() {
		String view = "";
		try {
			if (afiliado.getcAfiliado() != null) {// update
				afiliadoBusiness.update(afiliado);
				Message.messageInfo("Registro actualizado exitosamente");
				this.limpiarFormulario();
				view = "/afiliado/list";

			} else {// save
				afiliadoBusiness.insert(afiliado);
				Message.messageInfo("Registro guardado exitosamente");
				this.limpiarFormulario();
				view = "/afiliado/login";
			}
		} catch (Exception e) {
			Message.messageError("Error ProductController:" + e.getMessage());
		}
		return view;
	}

	public String loginAfiliado() {
		return "/afiliado/login";
	}

	public String verificarLogin() {
		String view = "";
		try {
			afiliados = afiliadoBusiness.getFindLogin(filCorreo, filPassword);
			limpiarFormulario();

			if (afiliados.isEmpty()) {
				Message.messageInfo("No se encuentra registrado");
				view = "/afiliado/login";
			} else {
				view = "/afiliado/list";
			}

		} catch (Exception e) {
		}
		return view;
	}

	public String regresarLogin() {
		return "/afiliado/login";
	}

	public String regresarLista() {
		return "/afiliado/list";
	}

	public void limpiarFormulario() {
		afiliado = new Afiliado();
	}

	public String vacio() {
		return "";
	}

	//////////////////////////////////
	public AfiliadoBusiness getAfiliadoBusiness() {
		return afiliadoBusiness;
	}

	public void setAfiliadoBusiness(AfiliadoBusiness afiliadoBusiness) {
		this.afiliadoBusiness = afiliadoBusiness;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Afiliado getAfiliadoSelected() {
		return afiliadoSelected;
	}

	public void setAfiliadoSelected(Afiliado afiliadoSelected) {
		this.afiliadoSelected = afiliadoSelected;
	}

	public List<Afiliado> getAfiliados() {
		return afiliados;
	}

	public void setAfiliados(List<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
