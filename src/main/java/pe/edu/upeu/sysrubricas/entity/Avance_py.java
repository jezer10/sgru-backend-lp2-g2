package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class Avance_py {
	int avance_py_id;
	int py_id;
	String estado;
	String titulo;
	String fecha_inicio;
	String fecha_fin;
	String tipo;
	int adjunto;
	int py_carga_id;
	String descripcion;

}
