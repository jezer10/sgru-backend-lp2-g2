package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class TipoDocumento {
	private int tipo_doc_id;
	private String nombre;
	private int digitos;
	private int estado;
}
