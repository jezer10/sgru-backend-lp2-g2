package pe.edu.upeu.sysrubricas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.LineaPlanDao;
import pe.edu.upeu.sysrubricas.entity.LineaPlan;
import pe.edu.upeu.sysrubricas.service.LineaPlanService;

import java.util.List;

@Service
public class LineaPlanServiceImp implements LineaPlanService {
    @Autowired
    LineaPlanDao lineaPlanDao;

    @Override
    public List<LineaPlan> getLineasPlan(int id) {
        return lineaPlanDao.getLineasPlan(id);
    }
}
