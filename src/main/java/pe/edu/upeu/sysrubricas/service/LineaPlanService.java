package pe.edu.upeu.sysrubricas.service;

import pe.edu.upeu.sysrubricas.entity.LineaPlan;

import java.util.List;

public interface LineaPlanService {
    List<LineaPlan> getLineasPlan(int id);
}
