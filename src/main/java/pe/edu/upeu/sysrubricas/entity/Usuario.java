package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class Usuario {
	private int persona_id;
	private String username;
	private String password;
	private String estado;

}
