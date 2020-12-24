package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grupos_Estudiante {
	private int gr_es_id;
	private int py_grupo_id;
	private int persona_id;
	private String estado;
}