package fr.univbrest.dosi.repositories;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import fr.univbrest.dosi.SpiApplication;
import fr.univbrest.dosi.bean.Candidat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class CandidatRepositoryTest {

	@Autowired
	CandidatRepository candidatRepo;

	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("12", "Kergoat", "29200", "oussama@gmail.com", "Rhelimi", "Oussama",
				"M", "UBO");
		Candidat candidat2 = new Candidat("13", "Kergoat", "29200", "oussamasse@gmail.com", "test", "test", "M",
				"UBO");
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
	}

	@Test
	public void doitCompterLesCandidats() {
		long resultat = candidatRepo.count();

		assertThat(resultat).isEqualTo(2);
	}

	@Test
	public void doitRechercherParNomFormation() {
		assertThat(candidatRepo.findByNoCandidat("12").size()).isEqualTo(2);

	}

	@Test
	 public void doitRechercherParUniversiteOrigine() {
		 List<Candidat> resultat = candidatRepo.findByUniversiteOrigine("UBO");
		 assertThat(resultat).hasSize(2);
	 }

}