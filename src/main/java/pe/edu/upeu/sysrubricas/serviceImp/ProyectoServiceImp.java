package pe.edu.upeu.sysrubricas.serviceImp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.ProyectoDao;

import pe.edu.upeu.sysrubricas.entity.Cursos;
import pe.edu.upeu.sysrubricas.entity.Proyecto;
import pe.edu.upeu.sysrubricas.service.ProyectoService;

import java.util.List;

@Service
public class ProyectoServiceImp implements ProyectoService {

    @Autowired
    private ProyectoDao proyectoDao;

	@Override
	public List<Proyecto> getProyecto(int id) {
		// TODO Auto-generated method stub
		return proyectoDao.getProyecto(id);
	}

	@Override
	public List<Cursos> getCursosxPy(int id) {
		// TODO Auto-generated method stub
		return proyectoDao.getCursosxPy(id);
	}

	@Override
	public List<Proyecto> comoBuscar(int id) {
		// TODO Auto-generated method stub
		return proyectoDao.comoBuscar(id);
	}

   
}
