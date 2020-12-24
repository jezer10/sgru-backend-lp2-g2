package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.TipoDocumentoDao;
import pe.edu.upeu.sysrubricas.service.TipoDocumentoService;
@Service
public class TipoDocumentoServiceImp implements TipoDocumentoService {
	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return tipoDocumentoDao.readAll();
	}

}
