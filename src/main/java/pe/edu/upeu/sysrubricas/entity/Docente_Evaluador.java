package pe.edu.upeu.sysrubricas.entity;
public class Docente_Evaluador {
	private int persona_id;
	private int tipo_evaluador_id;
	private String correo_trabajo;
	private String grado_academico;
	private String estado;
	public Docente_Evaluador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Docente_Evaluador(int persona_id, int tipo_evaluador_id, String correo_trabajo, String grado_academico,
			String estado) {
		super();
		this.persona_id = persona_id;
		this.tipo_evaluador_id = tipo_evaluador_id;
		this.correo_trabajo = correo_trabajo;
		this.grado_academico = grado_academico;
		this.estado = estado;
	}
	public int getPersona_id() {
		return persona_id;
	}
	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}
	public int getTipo_evaluador_id() {
		return tipo_evaluador_id;
	}
	public void setTipo_evaluador_id(int tipo_evaluador_id) {
		this.tipo_evaluador_id = tipo_evaluador_id;
	}
	public String getCorreo_trabajo() {
		return correo_trabajo;
	}
	public void setCorreo_trabajo(String correo_trabajo) {
		this.correo_trabajo = correo_trabajo;
	}
	public String getGrado_academico() {
		return grado_academico;
	}
	public void setGrado_academico(String grado_academico) {
		this.grado_academico = grado_academico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}