package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Nivel_Competencias_Curso {
	 int nivel_competencias_curso_id;
	 int nivel_competencias_id;
	 int plan_curso_id;
	 String estado;

}
