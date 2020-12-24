package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Competencias {
	int competencias_id;
	 int tipo_competencias_id;
	 String nombre;
	 String descripcion;
	 String estado;
}
