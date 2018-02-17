package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import fr.univbrest.dosi.SpiApplication;
import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.CandidatRepository;


public class CandidatBusinessJPATest {

	
	CandidatBusinessJPA business;
	CandidatRepository repos;
	@Before
	public void setup() {
		repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("12", "Kergoat", "29200", "oussama@gmail.com", "Rhelimi", "Oussama",
				"M", "UBO");
		Candidat candidat2 = new Candidat("13", "Kergoat", "29200", "oussamasse@gmail.com", "test", "test", "M",
				"UBO");
		
		repos.save(candidat1);
		repos.save(candidat2);
		}
	
	
	
	@Test
	public void doitTrouverEnseignatParCodeCandidat() {
		assertThat(business.getCandidatByNo("12").size()).isEqualTo(1);
	}
	
	@Test
	public void doitTrouverEnseignatParUniv() {
		assertThat(business.getCandidatByUniv("UBO").size()).isEqualTo(2);
	}
	
	@Test
	public void doitTrouverAllCandidats (){
		assertThat(business.getCandidats().size()).isEqualTo(2);
	}
	
	public class CandidatRepositoryList implements CandidatRepository {

		private List<Candidat> data;
		
		public CandidatRepositoryList() 
		{
			data = Lists.newArrayList(); 
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteInBatch(Iterable<Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Candidat> findAll() {
			return data ;
		}

		@Override
		public List<Candidat> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> List<S> findAll(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> List<S> findAll(Example<S> arg0, Sort arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Candidat getOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> List<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Candidat> findAll(Pageable arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			return 	data.size() ;
		}

		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Candidat entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S save(S entity) {
			data.add(entity) ;
			return entity ;
		}

		@Override
		public <S extends Candidat> long count(Example<S> arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Candidat> boolean exists(Example<S> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <S extends Candidat> Page<S> findAll(Example<S> arg0, Pageable arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S findOne(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByNoCandidat(String nomCandidat) {
			return data.stream().filter(e -> e.getNoCandidat() == nomCandidat ).collect(Collectors.toList());
		}

		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
			return data.stream().filter(e -> e.getUniversiteOrigine() == universiteOrigine ).collect(Collectors.toList());
		}
		
		
	}
	
}
		