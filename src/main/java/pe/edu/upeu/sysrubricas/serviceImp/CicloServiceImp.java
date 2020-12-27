package pe.edu.upeu.sysrubricas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.CicloDao;
import pe.edu.upeu.sysrubricas.entity.Ciclo;
import pe.edu.upeu.sysrubricas.service.CicloService;

import java.util.List;

@Service
public class CicloServiceImp implements CicloService {

    @Autowired
    private CicloDao cicloDao;

    @Override
    public List<Ciclo> getCiclos(int id) {
        return cicloDao.getCiclos(id);
    }
}
