package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Plan_curso {
	private int plan_curso_id;
	private int plan_id;
	private int curso_id;
	private  String ciclo;
	private String estado;
}
