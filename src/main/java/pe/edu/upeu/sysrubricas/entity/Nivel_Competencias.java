package pe.edu.upeu.sysrubricas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Nivel_Competencias {
	 int nivel_competencias_id;
	 int competencias_id;
	 int utils_id;
	 String estado;
}
