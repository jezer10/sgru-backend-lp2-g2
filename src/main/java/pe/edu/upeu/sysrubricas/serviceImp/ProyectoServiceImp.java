package pe.edu.upeu.sysrubricas.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.ProyectoDao;
import pe.edu.upeu.sysrubricas.entity.Curso;
import pe.edu.upeu.sysrubricas.entity.Proyecto;
import pe.edu.upeu.sysrubricas.service.ProyectoService;

import java.util.List;

@Service
public class ProyectoServiceImp implements ProyectoService {

    @Autowired
    private ProyectoDao proyectoDao;

    @Override
    public List<Proyecto> getProyecto(int id) {
        return proyectoDao.getProyecto(id);
    }

    @Override
    public List<Curso> getCursosxPy(int id) {
        return proyectoDao.getCursosxPy(id);
    }

    @Override
    public List<Proyecto> comoBuscar(int id) {
        return proyectoDao.comoBuscar(id);
    }
}
