package Sablon.Test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Reprezentacija;
import Sablon.Test.repository.ReprezentacijaRepository;
import Sablon.Test.service.ReprezentacijaService;

@Service
public class JpaReprezentacijaService implements ReprezentacijaService{ 
	 @Autowired
	 private ReprezentacijaRepository reprezentacijaRepository;

	@Override
	public Reprezentacija findOne(Long id) {
		return reprezentacijaRepository.findOneById(id);
	}

	@Override
	public List<Reprezentacija> findAll() {
		return reprezentacijaRepository.findAll();
	}
	 

}
