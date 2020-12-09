package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Py_Grupos {
	private int py_grupo_id;
	private int utils_id;
	private int py_id;
	private String nombre_py;
	private String estado;
}