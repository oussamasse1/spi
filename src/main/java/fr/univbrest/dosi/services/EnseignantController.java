package fr.univbrest.dosi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
public class EnseignantController {

	private EnseignantBusiness business;
	
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/enseignant/creer")
    public void deleteByNoE(@RequestBody Enseignant E) {
		business.creerEnseignant(E);
		}
	
	@GetMapping(value = "/enseignant")
    public List<Enseignant> getAllData() {
		return business.getEnseignants();
    }
	
	@GetMapping(value = "/enseignant/pays/{pays}")
    public List<Enseignant> getAllDataByPays(@PathVariable String pays) {
		return business.getEnseignantByPays(pays);
    }
	
	@GetMapping(value = "/enseignant/no/{noEnseignant}")
    public List<Enseignant> getDataByNoEnseignant(@PathVariable long noEnseignant) {
		return business.getEnseignant(noEnseignant); 
    }
	
	@GetMapping(value = "/enseignant/emailperso/{mail:.+}")
    public List<Enseignant> getDataByMailEnseignant(@PathVariable String mail) {
		return business.getEnseignantByEmail(mail); 
    }
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/enseignant/deletebyno/{noEnseignant}")
    public void deleteByNoE(@PathVariable long noEnseignant) {
		business.supprimerByNoEnseignant(noEnseignant);
		}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/enseignant/delete")
    public void deleteE(@RequestBody Enseignant E) {
		business.supprimerEnseignant(E);
		}
	
	
	
}
