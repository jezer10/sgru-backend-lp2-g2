package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DocenteEvaluadorPersona extends Persona{

	private int tipo_evaluador_id;
	private String correo_trabajo;
	private String grado_academico;
	private int estado;
}
