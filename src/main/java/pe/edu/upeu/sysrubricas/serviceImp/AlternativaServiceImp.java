package pe.edu.upeu.sysrubricas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.AlternativaDao;
import pe.edu.upeu.sysrubricas.entity.Alternativa;
import pe.edu.upeu.sysrubricas.service.AlternativaService;
import pe.edu.upeu.sysrubricas.sql.SqlAlternativa;

import java.sql.SQLException;
import java.util.List;


@Service
public class AlternativaServiceImp implements AlternativaService {

    @Autowired
    private AlternativaDao alternativaDao;

    @Override
    public void createAlternativa(SqlAlternativa alternativa) {
        alternativaDao.createAlternativa(alternativa);
    }

    @Override
    public void updateAlternativa(SqlAlternativa alternativa) {
        alternativaDao.updateAlternativa(alternativa);
    }

    @Override
    public List<Alternativa> getAlternativas(int id) throws SQLException {
        return alternativaDao.getAlternativas(id);
    }

    @Override
    public void deleteAlternativa(int id) {
        alternativaDao.deleteAlternativa(id);
    }
}
