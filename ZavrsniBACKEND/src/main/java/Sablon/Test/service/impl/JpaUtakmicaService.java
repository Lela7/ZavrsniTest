package Sablon.Test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import Sablon.Test.model.Utakmica;
import Sablon.Test.repository.UtakmicaRepository;
import Sablon.Test.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService{
	
	@Autowired
	private UtakmicaRepository utakmicaRepository;

	@Override
	public Utakmica findOne(Long id) {
		return utakmicaRepository.findOneById(id);
	}

	@Override
	public Page<Utakmica> findAll(Integer pageNo) {
		return utakmicaRepository.findAll(PageRequest.of(pageNo, 2));
	}

	@Override
	public Utakmica save(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

//	@Override
//	public Utakmica delete(Long id) {
//		Optional<Utakmica> utakmica=utakmicaRepository.findById(id);
//		if (utakmica.isPresent()) {
//			utakmicaRepository.deleteById(id);
//			return utakmica.get();
//		}
//		return null;
//	}
	
	//gledala sam JpaProjekcija
	@Override
	public Utakmica delete(Long id) {
		Utakmica utakmica= findOne(id);
		if(utakmica!=null) {
			utakmica.getReprezentacijaA().getUtakmiceA().remove(utakmica);
			utakmica.getReprezentacijaB().getUtakmiceB().remove(utakmica);
			utakmica.setReprezentacijaA(null);
			utakmica.setReprezentacijaB(null);
			utakmica=utakmicaRepository.save(utakmica);
			utakmicaRepository.delete(utakmica);
			return utakmica;
		}
		return null;
	}

	
	//gledala sam JpaProjekcijaSerice od 55 linije koda
	@Override
	public Page<Utakmica> find(Long reprezentacijaAId, Long reprezentacijaBId, Integer pageNo) {
		if(reprezentacijaAId == null && reprezentacijaBId == null) {
			return utakmicaRepository.findAll(PageRequest.of(pageNo,2));
		} else if(reprezentacijaAId ==  null && reprezentacijaBId != null) {
			return utakmicaRepository.findByReprezentacijaBId(reprezentacijaBId, PageRequest.of(pageNo,2));
		} else if (reprezentacijaBId == null && reprezentacijaAId != null) {
			return utakmicaRepository.findByReprezentacijaAId(reprezentacijaAId, PageRequest.of(pageNo,2));
		}
		
return utakmicaRepository.findByReprezentacijaAIdAndReprezentacijaBId(reprezentacijaAId, reprezentacijaBId, PageRequest.of(pageNo, 2));
	}

	@Override
	public Page<Utakmica> findByReprezentacijaAId(Long reprezentacijaAId, Integer pageNo) {
		return utakmicaRepository.findByReprezentacijaAId(reprezentacijaAId, PageRequest.of(pageNo,2));
	}

	@Override
	public Page<Utakmica> findByReprezentacijaBId(Long reprezentacijaBId, Integer pageNo) {
		return utakmicaRepository.findByReprezentacijaBId(reprezentacijaBId, PageRequest.of (pageNo, 2));
	}

	//ovo mozda ne treba uopste: 6/2/2023
	
//	@Override
//	public List<Utakmica> findByReprezentacijaAId (Long reprezentacijaAId) {
//	return utakmicaRepository.findByReprezentacijaAId(reprezentacijaAId);	
//	}
//
//	@Override
//	public List<Utakmica> findByReprezentacijaBId(Long reprezentacijaBId) {
//		return utakmicaRepository.findByReprezentacijaBId(reprezentacijaBId);
//	}
	
}



	


	
	
	


