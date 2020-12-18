package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NivelesLogro {
    private int nivel_logro_id;
    private String nombre;
    private Double peso;
    private String estado;
}