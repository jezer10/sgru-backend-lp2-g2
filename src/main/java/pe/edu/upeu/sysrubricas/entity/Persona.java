package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class Persona {
	private int persona_id;
	private String nombres;
	private String apellidos;
	private int tipo_doc_id;
	private String n_doc;
	private String sexo;
	private String fecha_nac;
	private String correo;
	private String telefono;
	private int estado_civil_id;
}
