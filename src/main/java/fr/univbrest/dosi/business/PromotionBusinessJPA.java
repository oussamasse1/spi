package fr.univbrest.dosi.business;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;


@Component
public class PromotionBusinessJPA implements PromotionBusiness{

	//@Autowired
	private PromotionRepository repos;
	
	

	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos = repos;
	}



	@Override
	public Promotion getPromotion(String anneeUniversitaire, String codeFormation) {
		PromotionPK id = new PromotionPK();
		Promotion promo;
		id.setAnneeUniversitaire(anneeUniversitaire);
		id.setCodeFormation(codeFormation);
		promo = repos.findById(id);
		return promo;
	}



	@Override
	public List<Promotion> searchByCodeFormation(String codeFormation) {
		List<Promotion> promos = new ArrayList<Promotion>() ;
		for(Promotion promo : getAll()) {
			if((promo.getId().getCodeFormation()).equals(codeFormation)) 
				promos.add(promo);
		}
		return promos;
	}
		

	@Override
	public List<Promotion> searchByAnneeUniversitaire(String anneeUniversitaire) {
		List<Promotion> promos = new ArrayList<Promotion>() ;
		for(Promotion promo : repos.findAll()) {
			if(promo.getId().getAnneeUniversitaire().equals(anneeUniversitaire)) 
				promos.add(promo);
		}
		return promos;
	}


	@Override
	public List<Promotion> getAll() {
		
		return repos.findAll();
	}
}
