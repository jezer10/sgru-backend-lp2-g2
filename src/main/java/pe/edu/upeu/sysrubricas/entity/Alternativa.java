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
public class Alternativa {
    private BigDecimal alternativa_id;
    private BigDecimal pregunta_id;
    private String correcta_estado;
    private String nombre;
}