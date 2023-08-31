package Sablon.Test.service;

import java.util.List;

import Sablon.Test.model.Igrac;

public interface IgracService {
	
	Igrac findOne(Long id);
	
	List<Igrac> findAll();
	
	List<Igrac> find(List<Long> ids);

}
