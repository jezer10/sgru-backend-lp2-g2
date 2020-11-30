package pe.edu.upeu.sysrubricas.entity;

public class Nivel_logro {
	private int nivel_logro_id;
	private int utils_id;
	private char estado;
	private double peso;
	public Nivel_logro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nivel_logro(int nivel_logro_id, int utils_id, char estado, double peso) {
		super();
		this.nivel_logro_id = nivel_logro_id;
		this.utils_id = utils_id;
		this.estado = estado;
		this.peso = peso;
	}
	public int getNivel_logro_id() {
		return nivel_logro_id;
	}
	public void setNivel_logro_id(int nivel_logro_id) {
		this.nivel_logro_id = nivel_logro_id;
	}
	public int getUtils_id() {
		return utils_id;
	}
	public void setUtils_id(int utils_id) {
		this.utils_id = utils_id;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	

}
