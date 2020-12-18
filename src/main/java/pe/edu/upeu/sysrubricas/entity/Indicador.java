package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Indicador {
	int indicador_id;
	int rubrica_id;
	String nombre;
	Double peso;
	String estado;

}
