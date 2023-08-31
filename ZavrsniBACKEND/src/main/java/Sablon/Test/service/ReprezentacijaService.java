package Sablon.Test.service;

import java.util.List;

import Sablon.Test.model.Reprezentacija;

public interface ReprezentacijaService {
	
	Reprezentacija findOne(Long id);
	
	List<Reprezentacija> findAll();
	
	

}
