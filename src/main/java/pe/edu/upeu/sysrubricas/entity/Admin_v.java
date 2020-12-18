package pe.edu.upeu.sysrubricas.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin_v {
	private int py_id;
    private int py_carga_id;
    private String curso;
    private Double peso;
    private String indicador;
    private Double peso_indicador;
    private String descripcion;
    private String nivel_logro;
    private Double peso_logro;
}
