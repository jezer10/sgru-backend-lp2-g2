package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data


public class NivelRubrica {
	int nivel_rubrica_id;
	 int nivel_logro_id;
	 int indicador_id;
	 String descripcion;
	 String estado;

}
