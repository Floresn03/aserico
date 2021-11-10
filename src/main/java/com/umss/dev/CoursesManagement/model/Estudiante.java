package com.umss.dev.CoursesManagement.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Estudiante")
public class Estudiante {

	@JsonView({Views.estudianteViews.class, Views.usuarioViews.class})
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_estudiante;
	@JsonView({ Views.estudianteViews.class, Views.usuarioViews.class, Views.inscritosViews.class })
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	//@JsonView({ Views.estudianteViews.class, Views.usuarioViews.class })
	private String email;
	//@OneToMany(cascade = { CascadeType.ALL })
	//@JoinColumn(name = "id_estudiante")
	//@JsonView({Views.instructorViews.class, Views.usuarioViews.class})
	//private Set<Curso> cursos;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_estudiante")
	private Set<Usuario> usuarios;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellido_paterno, String apellido_materno, String email) {
		super();
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.email = email;
	}

	public long getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	/**public Set<Curso> getcursos() {
		return this.cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}*/

	

}
