package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Proyecto_cargaDao;
import pe.edu.upeu.sysrubricas.entity.Proyecto_carga;
import pe.edu.upeu.sysrubricas.service.Proyecto_cargaService;

@Service
public class Proyecto_cargaServiceImp implements Proyecto_cargaService{
	
	@Autowired
	Proyecto_cargaDao proyecto_cargaDao;

	@Override
	public List<Proyecto_carga> Cursopy() {
		// TODO Auto-generated method stub
		return proyecto_cargaDao.Cursopy();
	}
	

}
