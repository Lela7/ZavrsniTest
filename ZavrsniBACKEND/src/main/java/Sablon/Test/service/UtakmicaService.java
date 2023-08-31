package Sablon.Test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Sablon.Test.model.Utakmica;

public interface UtakmicaService {
	
	Utakmica findOne(Long id);
	
	Page<Utakmica> findAll(Integer pageNo);
	
	Utakmica save(Utakmica utakmica);
	
	Utakmica update(Utakmica utakmica);
	
	Utakmica delete (Long id);
	
	Page<Utakmica> find (Long reprezentacijaAId,Long reprezentacijaBId, Integer pageNo);
	
	//dodajem sledece da probam 7/2/2023:
	
	Page<Utakmica> findByReprezentacijaAId (Long reprezentacijaAId, Integer pageNo);
	Page<Utakmica> findByReprezentacijaBId (Long reprezentacijaBId, Integer pageNo);

	
	//ovo mozda uopste ne treba: 6/2/2023
//	List<Utakmica> findByReprezentacijaAId(Long reprezentacijaAId);
//	
//	List<Utakmica> findByReprezentacijaBId(Long reprezentacijaBId);

	

	
	

}
