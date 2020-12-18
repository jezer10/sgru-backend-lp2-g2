package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Rubrica {
	 int rubrica_id;
	 int nivel_competencias_curso_id;
	 int py_carga_id;
	 String estado;
	 private Double peso;
}
