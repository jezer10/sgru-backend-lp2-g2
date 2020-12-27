package pe.edu.upeu.sysrubricas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.CompetenciaLineaDao;
import pe.edu.upeu.sysrubricas.entity.CompetenciaLinea;
import pe.edu.upeu.sysrubricas.service.CompetenciaLineaService;

import java.util.List;

@Service
public class CompetenciaLineaServiceImp implements CompetenciaLineaService {
    @Autowired
    private CompetenciaLineaDao competenciaLineaDao;


    @Override
    public List<CompetenciaLinea> getCompetenciasLinea(int id) {
        return competenciaLineaDao.getCompetenciasLinea(id);
    }
}
