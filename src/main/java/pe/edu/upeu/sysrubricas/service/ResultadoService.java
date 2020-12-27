package pe.edu.upeu.sysrubricas.service;

import pe.edu.upeu.sysrubricas.entity.Conf_evaluacion;
import pe.edu.upeu.sysrubricas.entity.Conf_py;
import pe.edu.upeu.sysrubricas.entity.Estudiante;

import java.util.List;

public interface ResultadoService {
    List<Estudiante> getEstudiante();
    List<Conf_py> getConf_py(String nombre);
    List<Conf_evaluacion> getConf_evaluacion(int id);
}
