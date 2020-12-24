package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class DocenteEvaluador {
	private int persona_id;
	private int tipo_evaluador_id;
	private String correo_trabajo;
	private String Grado_Academico;
	private int estado;
}
