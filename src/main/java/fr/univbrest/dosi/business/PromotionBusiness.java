package fr.univbrest.dosi.business;



import java.util.List;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.repositories.PromotionRepository;

public interface PromotionBusiness{
	
	Promotion getPromotion(String anneeUniversitaire, String codeFormation);
	List<Promotion> searchByAnneeUniversitaire(String anneeUniversitaire);
	List<Promotion> searchByCodeFormation(String codeFormation);
	List<Promotion> getAll();
}
