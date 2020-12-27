package pe.edu.upeu.sysrubricas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.InstrumentoDao;
import pe.edu.upeu.sysrubricas.entity.Instrumento;
import pe.edu.upeu.sysrubricas.service.InstrumentoService;
import pe.edu.upeu.sysrubricas.sql.SqlInstrumento;

import java.sql.SQLException;
import java.util.List;

@Service
public class InstrumentoServiceImp implements InstrumentoService {
    //private Hashtable<String, Instrumento> instrumentos = new Hashtable<String,Instrumento>();

    @Autowired
    private InstrumentoDao instrumentoDao;

    @Override
    public void createInstrumento(SqlInstrumento instrumento) {
        instrumentoDao.createInstrumento(instrumento);
    }

    @Override
    public void updateInstrumento(SqlInstrumento instrumento) {
        instrumentoDao.updateInstrumento(instrumento);
    }

    @Override
    public Instrumento getInstrumento(int id) throws SQLException {
        //instrumentos.put("instrumento",instrumentoDao.getInstrumento(id));
        return instrumentoDao.getInstrumento(id);
    }

    @Override
    public List<Instrumento> getInstrumentos() {
        return instrumentoDao.getInstrumentos();
    }

    @Override
    public List<Instrumento> getInstrumentosxsem(int id) {
        return instrumentoDao.getInstrumentosxsem(id);
    }

    @Override
    public void deleteInstrumento(int id) {
        instrumentoDao.deleteInstrumento(id);
    }
}
