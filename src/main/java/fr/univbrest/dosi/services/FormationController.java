package fr.univbrest.dosi.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController
public class FormationController {
	private FormationBusiness business;
	
	@Autowired
	public FormationController(FormationBusiness business) {
		this.business = business;
	}
	
	@GetMapping(value = "/formation/code/{codeFormation}")
    public List<Formation> getDataByCode(@PathVariable String codeFormation) {
		return business.getFormationByCode(codeFormation);
      
    }
	
	@GetMapping(value = "/formation/nom/{nomFormation}")
    public List<Formation> getDataByNom(@PathVariable String nomFormation) {
		return business.getFormationByNom(nomFormation);
      
    }
	
	public void getAll() {
		
		business.showAll();
    }

}
