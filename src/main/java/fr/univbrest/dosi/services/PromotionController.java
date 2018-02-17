package fr.univbrest.dosi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.business.FormationBusiness;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
public class PromotionController {
	
	private PromotionBusiness business;
	
	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}
	
	
	@GetMapping(value = "/promotion/{anneeUniversitaire}/{codeFormation}")
    public Promotion getDataById(@PathVariable String anneeUniversitaire, @PathVariable String codeFormation) {
		return business.getPromotion(anneeUniversitaire, codeFormation);

    }
	
	@GetMapping(value = "/promotion/annee/{anneeUniversitaire}")
    public List<Promotion> getDataByAnneeUniversitaire(@PathVariable String anneeUniversitaire) {
		 return business.searchByAnneeUniversitaire(anneeUniversitaire);
    
    }
	
	@GetMapping(value = "/promotion/code/{codeFormation}")
    public List<Promotion> getDataByCodeFormation(@PathVariable String codeFormation) {
		 return business.searchByCodeFormation(codeFormation);
    
    }
	
	@GetMapping(value = "/promotion")
    public List<Promotion> getData() {
		return business.getAll();

    }
}
