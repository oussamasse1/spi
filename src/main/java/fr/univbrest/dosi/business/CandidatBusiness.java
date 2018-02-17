package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatBusiness {
	List<Candidat> getCandidatByNo(String noCandidat);
	List<Candidat> getCandidatByUniv(String univ);
	List<Candidat> getCandidats();
}
