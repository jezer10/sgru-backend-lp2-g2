package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Competencia_Linea {
	int cl_id;
	int competencias_id;
	int linea_plan_id;
	String estado;
}
