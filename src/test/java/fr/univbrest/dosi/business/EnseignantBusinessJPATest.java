package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

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
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;


public class EnseignantBusinessJPATest {

	
	EnseignantBusinessJPA business;
	EnseignantRepository repos;
	@Before
	public void setup() {
		repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		business.creerEnseignant(new Enseignant((long)8, "oussamasse@gmail.com", "RHELIMI", "FR","Oussama", "H", "Tanger"));
		business.creerEnseignant(new Enseignant(9, "oussamasse@live.fr", "RHE", "FR", "Omar","H", "Brest"));
		}
	
	
	@Test
	public void doitCreerUneEnseignant() {
		assertThat(repos.count()).isEqualTo(2);
	}
	
	@Test
	public void doitTrouverEnseignatParNoEnseignant() {
		assertThat(business.getEnseignant(8)).isNotNull();
	}
	
	@Test
	public void doitTrouverEnseignatParPays() {
		assertThat(business.getEnseignantByPays("FR")).isNotNull();
	}
	
	@Test
	public void doitTrouverEnseignatParEmailPerso() {
		assertThat(business.getEnseignantByEmail("oussamasse@live.fr")).isNotNull();
	}
	
	@Test
	public void doitTrouverAllEnseignants (){
		assertThat(business.getEnseignants().size()).isEqualTo(2);
	}
	
	@Test
	public void doitSupprimerEnseignant() {
		business.supprimerByNoEnseignant((long)8);
		assertThat(repos.count()).isEqualTo(2);
	}
	
	
	
	public class EnseignantRepositoryList implements EnseignantRepository {

		private List<Enseignant> data;
		
		public EnseignantRepositoryList() 
		{
			data = Lists.newArrayList(); 
		}
		
		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteInBatch(Iterable<Enseignant> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Enseignant> findAll() {
			return data ;
		}

		@Override
		public List<Enseignant> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Enseignant> findAll(Iterable<Long> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Enseignant> List<S> findAll(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Enseignant> List<S> findAll(Example<S> arg0, Sort arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Enseignant getOne(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Enseignant> List<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		

		@Override
		public Page<Enseignant> findAll(Pageable arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			return 	data.size() ; 
		}

		@Override
		public void delete(Long arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Enseignant entity) {
			data.remove(entity);
		}

		@Override
		public void delete(Iterable<? extends Enseignant> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(Long arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Enseignant findOne(Long id) {
			return data.get((int) (long) id ) ;
		}

		@Override
		public <S extends Enseignant> S save(S entity) {
			data.add(entity) ;
			return entity ;
		}

		@Override
		public <S extends Enseignant> long count(Example<S> arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Enseignant> boolean exists(Example<S> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <S extends Enseignant> Page<S> findAll(Example<S> arg0, Pageable arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Enseignant> S findOne(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Enseignant> findByNoEnseignant(long noEnseignant) {
			 return  data.stream().filter(e -> e.getNoEnseignant() ==noEnseignant ).collect(Collectors.toList());
			}

		@Override
		public List<Enseignant> findByEmailPerso(String mail) {
			return  data.stream().filter(e -> e.getEmailPerso().equals(mail)).collect(Collectors.toList());
		}

		@Override
		public List<Enseignant> findByPays(String pays) {
			return data.stream().filter(e -> e.getPays().equals(pays)).collect(Collectors.toList());
		}

		@Override
		public void deleteByNoEnseignant(long noEnseignant) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Enseignant> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
}
		