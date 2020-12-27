package pe.edu.upeu.sysrubricas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.ResultadoDao;
import pe.edu.upeu.sysrubricas.entity.Conf_evaluacion;
import pe.edu.upeu.sysrubricas.entity.Conf_py;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
import pe.edu.upeu.sysrubricas.service.ResultadoService;

import java.util.List;

@Service
public class ResultadoServiceImp implements ResultadoService {

    @Autowired
    private ResultadoDao resultadoDao;

    @Override
    public List<Estudiante> getEstudiante() {
        return resultadoDao.getEstudiante();
    }

    @Override
    public List<Conf_py> getConf_py(String nombre) {
        return resultadoDao.getConf_py(nombre);
    }

    @Override
    public List<Conf_evaluacion> getConf_evaluacion(int id) {
        return resultadoDao.getConf_evaluacion(id);
    }
}
