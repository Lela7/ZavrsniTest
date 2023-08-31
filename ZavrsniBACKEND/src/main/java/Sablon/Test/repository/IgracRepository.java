package Sablon.Test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Igrac;
@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long>{
	
	Igrac findOneById(Long id);
	
	List<Igrac> findByIdIn(List<Long> ids);
	
	

}
