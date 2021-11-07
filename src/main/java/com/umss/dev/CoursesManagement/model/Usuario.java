package com.umss.dev.CoursesManagement.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.usuarioViews.class)
	private Long id_usuario;
	@JsonView(Views.usuarioViews.class)
	private String username;
	@JsonView(Views.usuarioViews.class)
	private String passwd;
	@JsonView(Views.usuarioViews.class)
	private String email;
	@JsonView(Views.usuarioViews.class)
	private TipoUsuarioEnum tipoUsuarioId;
	@OneToOne
	@JoinColumn(name = "id_instructor")
	private Instructor instructor;
	@OneToOne
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;

	/**
	 * @ManyToOne
	 * @JoinColumn(name = "id_instructor") // @JsonView(Views.usuarioViews.class)
	 *                  private Instructor instructor;
	 * @JsonView(Views.usuarioViews.class) @ManyToOne
	 * @JoinColumn(name = "id_estudiante") private Estudiante estudiante;
	 */

	public Usuario() {
		super();
	}

	

	public Usuario(String username, String passwd, String email, Instructor instructor, Estudiante estudiante) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.instructor = instructor;
		this.estudiante = estudiante;
	}

	public enum TipoUsuarioEnum {
		INSTRUCTOR(1), ESTUDIANTE(2);

		private final Integer valor;

		// el constructor Enum deberia estar en privado
		private TipoUsuarioEnum(Integer valor) {
			this.valor = valor;

		}

		public Integer getValor() {
			return valor;
		}

		public static TipoUsuarioEnum parse(Integer id) {
			TipoUsuarioEnum status = null; // por defecto
			for (TipoUsuarioEnum item : TipoUsuarioEnum.values()) {
				if (item.getValor().equals(id)) {
					status = item;
					break;
				}
			}
			return status;

		}

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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoUsuarioEnum getTipoUsuarioId() {
		return tipoUsuarioId;
	}

	public void setTipoUsuarioId(TipoUsuarioEnum tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}

	

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}