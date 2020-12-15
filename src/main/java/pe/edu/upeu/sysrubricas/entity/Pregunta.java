package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pregunta {
    private BigDecimal pregunta_id;
    private BigDecimal instrumento_id;
    private String nombre;
    private BigDecimal peso;
    private String estado;
}
