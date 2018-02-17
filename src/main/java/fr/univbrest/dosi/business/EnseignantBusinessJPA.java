package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Component
public class EnseignantBusinessJPA implements EnseignantBusiness{
	//@Autowired
	private EnseignantRepository repos;
	
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		this.repos = repos;
	}

	@Override
	public List<Enseignant> getEnseignant(long noEnseignant) {
		return repos.findByNoEnseignant(noEnseignant);
	}

	@Override
	public Enseignant creerEnseignant(Enseignant E) {
		return repos.save(E);
	}

	@Override
	public void supprimerEnseignant(Enseignant E) {
		repos.delete(E);
		}

	@Override
	public void supprimerByNoEnseignant(long noE) {
		repos.delete(noE);
		//repos.deleteByNoEnseignant(noE);
	}

	@Override
	public List<Enseignant> getEnseignants() {
		return repos.findAll();
	}

	@Override
	public List<Enseignant> getEnseignantByEmail(String mail) {
		return repos.findByEmailPerso(mail);
	}

	public List<Enseignant> getEnseignantByPays(String pays) {
		return repos.findByPays(pays);
	}
	
	/*
 	@Override(non-Javadoc)
	public Enseignant updateEnseignant(Enseignant E, Enseignant nouveauE) {
		
	}*/
	
	
	
	
}
