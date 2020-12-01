package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Plan {
	private int plan_id;
	private int ua_id;
	private String nombre;
	private String f_ini;
	private String f_fin;
	private String estado;
}
