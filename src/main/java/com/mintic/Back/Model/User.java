package com.mintic.Back.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
	public static final String TABLE_NAME = "usuarios";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idTipo_Documento")
	private TypeDocument idTipo_Documento;
	
	/*@Column nombre de la columna , si el nombre en la base de datos del campo es igual
	 *  a el de la variable no es necesario poner la anotacion
	 * */
	@Column(name = "cedula_usuario")
	private String cedula_usuario;

	@Column(name = "email_usuario")
	private String email_usuario;

	@Column(name = "nombre_usuario")
	private String nombre_usuario;

	@Column(name = "pasword")
	private String pasword;

	@Column(name = "usuario")
	private String usuario;

	public User() {

	}
	
	public User(Long id, TypeDocument idTipo_Documento, String cedula_usuario, String email_usuario,
			String nombre_usuario, String pasword, String usuario) {
		this.id = id;
		this.idTipo_Documento = idTipo_Documento;
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.pasword = pasword;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeDocument getIdTipo_Documento() {
		return idTipo_Documento;
	}

	public void setIdTipo_Documento(TypeDocument idTipo_Documento) {
		this.idTipo_Documento = idTipo_Documento;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}
}
