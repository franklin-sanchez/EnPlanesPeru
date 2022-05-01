package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cUsuario;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nUsuarioNombre;
	@Column(name = "apellido", nullable = false, length = 50)
	private String nUsuarioApellido;
	@Column(name = "correo", nullable = false, length = 30)
	private String tCorreo;
	@Column(name = "celular", length = 25)
	private Long numCelular;
	@Column(name = "contrasenia", nullable = false, length = 15)
	private String tPassword;
	@Column(name = "confirmar_Contrasenia", nullable = false, length = 15)
	private String tConfirmPassword;

	public Long getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(Long cUser) {
		this.cUsuario = cUser;
	}

	public String getnUsuarioNombre() {
		return nUsuarioNombre;
	}

	public void setnUsuarioNombre(String nUsuarioNombre) {
		this.nUsuarioNombre = nUsuarioNombre;
	}

	public String getnUsuarioApellido() {
		return nUsuarioApellido;
	}

	public void setnUsuarioApellido(String nUsuarioApellido) {
		this.nUsuarioApellido = nUsuarioApellido;
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
