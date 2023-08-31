package Sablon.Test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Igrac;
import Sablon.Test.repository.IgracRepository;
import Sablon.Test.service.IgracService;

@Service
public class JpaIgracService implements IgracService{
	
	@Autowired
	private IgracRepository igracRepository;

	@Override
	public Igrac findOne(Long id) {
		return igracRepository.findOneById(id);
	}

	@Override
	public List<Igrac> findAll() {
		return igracRepository.findAll();
	}

	@Override
	public List<Igrac> find(List<Long> ids) {
		return igracRepository.findByIdIn(ids);
	}
	
	

}
