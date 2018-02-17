package fr.univbrest.dosi.repositories;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import fr.univbrest.dosi.SpiApplication;
import fr.univbrest.dosi.SpiApplicationTests;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpiApplication.class, loader = AnnotationConfigContextLoader.class)
@WebMvcTest
public class PromotionRepositoryTest {

	@Autowired
	static PromotionRepository PromotionRepo;

	@BeforeClass
	public static void setup() {
		
		PromotionPK pro1pk = new PromotionPK("M2DOSI","2017-2018");
		PromotionPK pro2pk = new PromotionPK("M2TIIL","2017-2018");
		Promotion Promotion1 = new Promotion(pro1pk, "DOSI6");
		Promotion Promotion2 = new Promotion(pro2pk, "TIIL6");
		PromotionRepo.save(Promotion1);
		PromotionRepo.save(Promotion2);
	}

	@Test
	public void doitCompterLesPromotions() {
		long resultat = PromotionRepo.count();

		assertThat(resultat).isEqualTo(2);
	}

	/*
	@Test
	 public void doitRechercherParUniversiteOrigine() {
		 List<Promotion> resultat = PromotionRepo.findById("UBO");
		 assertThat(resultat).hasSize(2);
	 }
	 */

}