package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.Cursos;
import pe.edu.upeu.sysrubricas.entity.Proyecto;

import java.util.List;


public interface ProyectoDao {
	   List<Proyecto> getProyecto(int id);
	    List<Cursos> getCursosxPy(int id);
	    List<Proyecto> comoBuscar(int id);
}
