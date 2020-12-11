package pe.edu.upeu.sysrubricas.entity;

public class Utils {
    private int utils_id;
    private String nombre;
    private char estado;
	public Utils() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utils(int utils_id, String nombre, char estado) {
		super();
		this.utils_id = utils_id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getUtils_id() {
		return utils_id;
	}
	public void setUtils_id(int utils_id) {
		this.utils_id = utils_id;
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
