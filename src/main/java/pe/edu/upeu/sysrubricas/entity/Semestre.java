package pe.edu.upeu.sysrubricas.entity;

public class Semestre {
	private int semestre_id;
	private String nombre;
	private char estado;
	public Semestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Semestre(int semestre_id, String nombre, char estado) {
		super();
		this.semestre_id = semestre_id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getSemestre_id() {
		return semestre_id;
	}
	public void setSemestre_id(int semestre_id) {
		this.semestre_id = semestre_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	

}
