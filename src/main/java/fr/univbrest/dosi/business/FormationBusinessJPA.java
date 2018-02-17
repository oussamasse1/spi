package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationBusinessJPA implements FormationBusiness{
	
	//@Autowired
	private FormationRepository repos;
	
	
	@Autowired
	public FormationBusinessJPA(FormationRepository repos) {
		this.repos = repos;
	}
	

	
	@Transactional
	public void showAll(){
		List<Formation> formation = (List<Formation>) repos.findAll();
		formation.forEach(System.out::println);	
	}

	@Override
	public List<Formation> getFormationByNom(String nomFormation) {
		return repos.findByNomFormation(nomFormation);
	}



	@Override
	public List<Formation> getFormationByCode(String codeFormation) {
		return repos.findByCodeFormation(codeFormation);
	}
	
	/*@Override
	public Formation creerFormation(Formation formationACree) {
		formationACree.setDebutAccreditation(new Date());
		//ajouter setFIN aussi
		return repos.save(formationACree);
		
	}

	@Override
	public void supprimerFormation(Formation formation) {
		
		repos.delete(formation);
		
	}*/

	

}
