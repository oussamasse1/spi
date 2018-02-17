package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;

public interface FormationBusiness {

	List<Formation> getFormationByCode(String codeFormation);
	List<Formation> getFormationByNom(String nomFormation);
	public void showAll();
	//void supprimerFormation(Formation formation);
}
