package pe.edu.upeu.sysrubricas.service;

import pe.edu.upeu.sysrubricas.entity.Curso;
import pe.edu.upeu.sysrubricas.entity.Cursos;
import pe.edu.upeu.sysrubricas.entity.Proyecto;

import java.util.List;

public interface ProyectoService {
    List<Proyecto> getProyecto(int id);
    List<Cursos> getCursosxPy(int id);
    List<Proyecto> comoBuscar(int id);
}
