package pe.edu.upeu.sysrubricas.entity;
public class Tipo_Evaluador {
	private int tipo_evaluador_id;
	private String nombre;
	private String estado;
	public Tipo_Evaluador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tipo_Evaluador(int tipo_evaluador_id, String nombre, String estado) {
		super();
		this.tipo_evaluador_id = tipo_evaluador_id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getTipo_evaluador_id() {
		return tipo_evaluador_id;
	}
	public void setTipo_evaluador_id(int tipo_evaluador_id) {
		this.tipo_evaluador_id = tipo_evaluador_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}