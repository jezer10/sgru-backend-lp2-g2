package pe.edu.upeu.sysrubricas.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
	private int curso_id;
	private String nombre;
	private String cr;
	private String ht;
	private String hp;
	private String estado;
}
