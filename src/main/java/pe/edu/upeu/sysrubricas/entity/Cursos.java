package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cursos {
	 private int py_carga_id;
	    private int py_id;
	    private int curso_id;
	    private String curso;
	    private String docente;
	    private String correo_trabajo;
}
