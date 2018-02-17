package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, String>{

	List<Candidat> findByNoCandidat(String noCandidat);
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);
}
