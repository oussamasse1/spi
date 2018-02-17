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
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import fr.univbrest.dosi.SpiApplication;
import fr.univbrest.dosi.SpiApplicationTests;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;



public class FormationBusinessJPATest {

	
	FormationBusinessJPA business;
	
	FormationRepository repos;
	
	@Before
	public void setup() {
		repos = new FormationRepositoryList();
		business = new FormationBusinessJPA(repos);
		Formation formation1 = new Formation("33", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");
		Formation formation2 = new Formation("34", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");
		
		repos.save(formation1);
		repos.save(formation2);
		}
	
	
	
	@Test
	public void doitTrouverEnseignatParCodeFormation() {
		assertThat(business.getFormationByCode("33").size()).isEqualTo(1);
	}
	
	@Test
	public void doitTrouverEnseignatParNoFormation() {
		assertThat(business.getFormationByNom("DOSI").size()).isEqualTo(2);
	}
	
	
	public class FormationRepositoryList implements FormationRepository {

		private List<Formation> data;
		
		public FormationRepositoryList() 
		{
			data = Lists.newArrayList(); 
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteInBatch(Iterable<Formation> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Formation> findAll(Sort arg0) {
			return data ;
		}

		@Override
		public List<Formation> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> List<S> findAll(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> List<S> findAll(Example<S> arg0, Sort arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Formation getOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> List<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Formation> findAll(Pageable arg0) {
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
		public void delete(Formation entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Formation> arg0) {
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
		public Formation findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity) ;
			return entity ;
		}

		@Override
		public <S extends Formation> long count(Example<S> arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Formation> boolean exists(Example<S> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <S extends Formation> Page<S> findAll(Example<S> arg0, Pageable arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> S findOne(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Formation> findByNomFormation(String nomFormation) {
			return data.stream().filter(e -> e.getNomFormation().equals(nomFormation)).collect(Collectors.toList());
		}

		@Override
		public List<Formation> findByCodeFormation(String codeFormation) {
			return  data.stream().filter(e -> e.getCodeFormation().equals(codeFormation)).collect(Collectors.toList());
		}
		
		
	}
	
}
		