package fr.univbrest.dosi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;


public interface PromotionRepository extends JpaRepository<Promotion, PromotionPK>{
	
	public Promotion findById(PromotionPK id);
	
		
}
