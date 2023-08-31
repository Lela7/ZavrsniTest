package Sablon.Test.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica, Long>{
	
	Utakmica findOneById(Long id);
	
	Page<Utakmica> findByReprezentacijaAIdAndReprezentacijaBId ( Long reprezentacijaAId, Long reprezentacijaBId, Pageable pageable);
	
	Page<Utakmica> findByReprezentacijaAId(Long reprezentacijaAId, Pageable pageable);
	
	Page<Utakmica> findByReprezentacijaBId(Long reprezentacijaBId, Pageable pageable);
	
//	List<Utakmica> findByReprezentacijaAId(Long reprezentacijaAId);
//	List<Utakmica> findByReprezentacijaBId(Long reprezentacijaBId);
	
	

}
