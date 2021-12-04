package com.umss.dev.CoursesManagement.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "Usuario",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username")
	})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.usuarioViews.class)
	private Long id_usuario;
	@NotBlank
	@JsonView(Views.usuarioViews.class)
	private String username;
	@NotBlank
	@JsonView(Views.usuarioViews.class)
	private String passwd;
	
	@JsonView(Views.usuarioViews.class)
	@ManyToOne
	@JoinColumn(name = "id_instructor")
	private Instructor instructor;
	
	
	@JsonView(Views.usuarioViews.class)
	@ManyToOne
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;
	
	@JsonView(Views.usuarioViews.class)
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;
	

	public Usuario() {
		super();
	}

	public Usuario(String username, String passwd, Instructor instructor, Estudiante estudiante) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.instructor = instructor;
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	
}