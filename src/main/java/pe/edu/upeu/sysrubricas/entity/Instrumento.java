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
	public Instrumento() {
		super();
	}
	public Instrumento(int instrumento_id, int semestre_id, int cl_id, int estado) {
		super();
		this.instrumento_id = instrumento_id;
		this.semestre_id = semestre_id;
		this.cl_id = cl_id;
		this.estado = estado;
	}
	public int getInstrumento_id() {
		return instrumento_id;
	}
	public void setInstrumento_id(int instrumento_id) {
		this.instrumento_id = instrumento_id;
	}
	public int getSemestre_id() {
		return semestre_id;
	}
	public void setSemestre_id(int semestre_id) {
		this.semestre_id = semestre_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
     
}
