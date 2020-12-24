package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Proyecto_Integrador {
	private int py_id;
	private int utils_id;
	private int semestre_id;
	private int n_grupos;
	private int n_cursos;
	private String estado;
	private int persona_id;
}