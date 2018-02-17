package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

@Component
public class CandidatBusinessJPA implements CandidatBusiness{
	
	@Autowired
	private CandidatRepository repos;

	public CandidatBusinessJPA(CandidatRepository repos) {
		this.repos = repos;
	}

	@Override
	public List<Candidat> getCandidatByNo(String noCandidat) {
		return repos.findByNoCandidat(noCandidat);
	}

	@Override
	public List<Candidat> getCandidatByUniv(String univ) {
		return repos.findByUniversiteOrigine(univ);
	}

	@Override
	public List<Candidat> getCandidats() {
		return repos.findAll();
	}

}
