package fr.univbrest.dosi.repositories;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import fr.univbrest.dosi.SpiApplication;
import fr.univbrest.dosi.SpiApplicationTests;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiApplication.class)
public class FormationRepositoryTest {
	
	@Autowired
	FormationRepository formationRepo;
	
	@Before
	public void setup() {
		Formation formation1 = new Formation("33", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");
		Formation formation2 = new Formation("34", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");
		formationRepo.delete(formation1);
		formationRepo.delete(formation2);
		
	}
	
	
	
	@Test
	public void doitCompterLesFomations() {
		long resultat = formationRepo.count();
		assertThat(resultat).isEqualTo(4);
		//Assert.assertNotNull(formationRepo.findByCodeFormation("33"));
	}
	
	/*@Test
	public void doitRechercherParNomFormation() {
		List<Formation> resultat = formationRepo.findByNomFormation("DOSI");
		assertThat(resultat).hasSize(2);
		assertThat(resultat.get(0).getNomFormation()).isEqualTo("DOSI");
		assertThat(resultat.get(0).getCodeFormation()).isEqualTo("33");
	}
	*/

}