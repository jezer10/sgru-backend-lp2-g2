package pe.edu.upeu.sysrubricas.entity;
public class Carga_Academica {
	private int carga_academica_id;
	private int semestre_id;
	private int persona_id;
	private int plan_curso_id;
	private String Estado;
	private String grupo;
	public Carga_Academica() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carga_Academica(int carga_academica_id, int semestre_id, int persona_id, int plan_curso_id, String estado,
			String grupo) {
		super();
		this.carga_academica_id = carga_academica_id;
		this.semestre_id = semestre_id;
		this.persona_id = persona_id;
		this.plan_curso_id = plan_curso_id;
		this.Estado = estado;
		this.grupo = grupo;
	}
	public int getCarga_academica_id() {
		return carga_academica_id;
	}
	public void setCarga_academica_id(int carga_academica_id) {
		this.carga_academica_id = carga_academica_id;
	}
	public int getSemestre_id() {
		return semestre_id;
	}
	public void setSemestre_id(int semestre_id) {
		this.semestre_id = semestre_id;
	}
	public int getPersona_id() {
		return persona_id;
	}
	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}
	public int getPlan_curso_id() {
		return plan_curso_id;
	}
	public void setPlan_curso_id(int plan_curso_id) {
		this.plan_curso_id = plan_curso_id;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
