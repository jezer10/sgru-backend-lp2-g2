package pe.edu.upeu.sysrubricas.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Linea_Plan{
	private int linea_plan_id;
	private int plan_id;
	private int lineas_pa_id;
	private String estado;
}