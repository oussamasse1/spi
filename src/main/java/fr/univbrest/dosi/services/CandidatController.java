package fr.univbrest.dosi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;



@RestController
public class CandidatController {

	private CandidatBusiness business;
	
	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business = business;
	}
	
	@GetMapping(value = "/candidat")
    public List<Candidat> getAllData() {
		return business.getCandidats();
    }
	
	@GetMapping(value = "/candidat/nom/{no}")
    public List<Candidat> getDataByNo(@PathVariable String no) {
		return business.getCandidatByNo(no);
    }
	
	@GetMapping(value = "/candidat/univ/{univ}")
    public List<Candidat> getDataByUniv(@PathVariable String univ) {
		return business.getCandidatByUniv(univ);
    }
	
}
