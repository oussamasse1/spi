package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{
	List<Enseignant> findByNoEnseignant(long noEnseignant);
	List<Enseignant> findByEmailPerso(String mail);
	List<Enseignant> findByPays(String pays);
	void deleteByNoEnseignant(long noEnseignant);
}
