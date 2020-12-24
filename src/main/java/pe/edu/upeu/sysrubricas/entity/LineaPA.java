package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LineaPA{
	private int lineas_pa_id;
	private String nombre;
	private String estado;
}
