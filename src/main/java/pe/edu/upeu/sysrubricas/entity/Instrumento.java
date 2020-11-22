package pe.edu.upeu.sysrubricas.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Instrumento {
     int instrumento_id;
     int semestre_id;
     int cl_id;
     int estado;
}
