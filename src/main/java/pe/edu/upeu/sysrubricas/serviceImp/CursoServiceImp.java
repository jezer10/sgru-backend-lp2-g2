package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.CursoDao;
import pe.edu.upeu.sysrubricas.entity.Curso;
import pe.edu.upeu.sysrubricas.service.CursoService;

@Service
public class CursoServiceImp implements CursoService{
	
	@Autowired
	CursoDao cursoDao;

	@Override
	public List<Curso> Cursopy() {
		// TODO Auto-generated method stub
		return cursoDao.Cursopy();
	}
	

}
