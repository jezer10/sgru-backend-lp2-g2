package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class Informe {
	private int informes_id;
	private int ua_id;
	private int semestre_id;
	private int utils_id;
	private int persona_id;
	private String documento;
}
