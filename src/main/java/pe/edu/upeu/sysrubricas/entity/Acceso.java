package pe.edu.upeu.sysrubricas.entity;

import lombok.Data;

@Data
public class Acceso {
	private int acceso_id;
	private String accessname;
	private String url;
	private String icon;
	private int parent_id;
	private String estado;

}
