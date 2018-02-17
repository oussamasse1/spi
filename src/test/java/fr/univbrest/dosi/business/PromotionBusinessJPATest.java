package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
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
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;


public class PromotionBusinessJPATest {

	
	PromotionBusinessJPA business;
	PromotionRepository repos;
	@Before
	public void setup() {
		repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK pk1 = new PromotionPK("2013-2014","M2TIIL");
		PromotionPK pk2 = new PromotionPK("2013-2014", "M2DOSI");
		Promotion Promotion1 = new Promotion(pk1, "TIIL1");
		Promotion Promotion2 = new Promotion(pk2, "DOSI1");
		
		repos.save(Promotion1);
		repos.save(Promotion2);
		}
	
	
	@Test
	public void doitTrouverEnseignatParCodePromotion() {
		assertThat(business.searchByAnneeUniversitaire("2013-2014").size()).isEqualTo(2);
	}
	
	@Test
	public void doitTrouverEnseignatParNoPromotion() {
		assertThat(business.searchByCodeFormation("M2DOSI").size()).isEqualTo(1);
	}
	
	@Test
	public void doitTrouverAllPromotions (){
		assertThat(business.getAll().size()).isEqualTo(2);
	}
	
	
	public class PromotionRepositoryList implements PromotionRepository {

		private List<Promotion> data;
		
		public PromotionRepositoryList() 
		{
			data = Lists.newArrayList(); 
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteInBatch(Iterable<Promotion> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Promotion> findAll() {
			return data ;
		}

		@Override
		public List<Promotion> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Promotion> findAll(Iterable<PromotionPK> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Promotion> List<S> findAll(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Promotion> List<S> findAll(Example<S> arg0, Sort arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Promotion getOne(PromotionPK arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Promotion> List<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Promotion> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Promotion> findAll(Pageable arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			return 	data.size() ;
		}

		@Override
		public void delete(PromotionPK arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Promotion entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Promotion> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(PromotionPK arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Promotion findOne(PromotionPK arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Promotion> S save(S entity) {
			data.add(entity) ;
			return entity ;
		}

		@Override
		public <S extends Promotion> long count(Example<S> arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Promotion> boolean exists(Example<S> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <S extends Promotion> Page<S> findAll(Example<S> arg0, Pageable arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Promotion> S findOne(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Promotion findById(PromotionPK id) {
			return (Promotion) data.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
		}
		
		
	}
	
}
		