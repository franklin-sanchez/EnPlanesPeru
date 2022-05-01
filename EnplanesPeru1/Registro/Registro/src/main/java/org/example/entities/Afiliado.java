package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "afiliado")
public class Afiliado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cAfiliado;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nAfiliadoNombre;
	@Column(name = "apellido", nullable = false, length = 50)
	private String nAfiliadoApellido;
	@Column(name = "nombre_empresa", nullable = false, length = 30)
	private String nEmpresa;
	@Column(name = "numero_ruc", nullable = false, length = 11)
	private Long numRuc;
	@Column(name = "correo", nullable = false, length = 30)
	private String tCorreo;
	@Column(name = "celular", length = 25)
	private Long numCelular;
	@Column(name = "contrasenia", nullable = false, length = 15)
	private String tPassword;
	@Column(name = "confirmar_Contrasenia", nullable = false, length = 15)
	private String tConfirmPassword;

	public Long getcAfiliado() {
		return cAfiliado;
	}

	public void setcAfiliado(Long cAfiliado) {
		this.cAfiliado = cAfiliado;
	}

	public String getnAfiliadoNombre() {
		return nAfiliadoNombre;
	}

	public void setnAfiliadoNombre(String nAfiliadoNombre) {
		this.nAfiliadoNombre = nAfiliadoNombre;
	}

	public String getnAfiliadoApellido() {
		return nAfiliadoApellido;
	}

	public void setnAfiliadoApellido(String nAfiliadoApellido) {
		this.nAfiliadoApellido = nAfiliadoApellido;
	}

	public String getnEmpresa() {
		return nEmpresa;
	}

	public void setnEmpresa(String nEmpresa) {
		this.nEmpresa = nEmpresa;
	}

	public Long getNumRuc() {
		return numRuc;
	}

	public void setNumRuc(Long numRuc) {
		this.numRuc = numRuc;
	}

	public String gettCorreo() {
		return tCorreo;
	}

	public void settCorreo(String tCorreo) {
		this.tCorreo = tCorreo;
	}

	public Long getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(Long numCelular) {
		this.numCelular = numCelular;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String gettConfirmPassword() {
		return tConfirmPassword;
	}

	public void settConfirmPassword(String tConfirmPassword) {
		this.tConfirmPassword = tConfirmPassword;
	}

}
