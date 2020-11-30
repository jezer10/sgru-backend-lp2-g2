package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class Evaluacion {
	int evaluacion_id;
	int nivel_rubrica_id;
	int est_persona_id;
	int eva_persona_id;
	String estado;

}
