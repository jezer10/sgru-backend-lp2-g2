package pe.edu.upeu.sysrubricas.service;

import pe.edu.upeu.sysrubricas.entity.*;

import java.util.List;

import pe.edu.upeu.sysrubricas.entity.Rubrica;

public interface RubricaService {
	 void createRubrica(Rubrica rubrica);
	    void createIndicador(Indicador indicador);
	    void createNivelRubrica(NivelRubrica nivelRubrica);
	    List<Rubrica_v> getRubricas(int id);
	    List<Rubrica_v> getOnlyRubrica(int id);
	    List<Indicador> getIndicador(int id);
	    List<Indicador> getOnlyIndicador(int id);
	    List<NivelesLogro> getNivelesLogro();
	    List<NivelRubrica_v> getNivelRubrica(int id);
	  
}
