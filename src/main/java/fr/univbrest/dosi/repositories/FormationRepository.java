package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Formation;

public interface FormationRepository extends JpaRepository<Formation, String> {

	List<Formation> findByNomFormation(String nomFormation);
	List<Formation> findByCodeFormation(String codeFormation);
	
}