package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Igrac;
import Sablon.Test.model.Reprezentacija;
import Sablon.Test.service.IgracService;
import Sablon.Test.service.ReprezentacijaService;
import Sablon.Test.web.dto.IgracDTO;
import Sablon.Test.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaDTOToReprezentacija implements Converter<ReprezentacijaDTO, Reprezentacija>{
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	
	@Autowired
	private IgracService igracService;
	
	@Override
	public Reprezentacija convert(ReprezentacijaDTO dto) {
		
		Reprezentacija reprezentacija;
		
		if(dto.getId()==null) {
			reprezentacija= new Reprezentacija();
		} else {
			reprezentacija=reprezentacijaService.findOne(dto.getId());
		}
		
		if(reprezentacija !=null) {
			reprezentacija.setNaziv(dto.getNaziv());
			reprezentacija.setSkraceniNaziv(dto.getSkraceniNaziv());
		
			
		if(dto.getIgraci() != null) {
			List <Long> idIgraca = dto.getIgraci().stream().map(IgracDTO::getId).collect(Collectors.toList());
			List<Igrac> igraci =igracService.find(idIgraca);
			reprezentacija.setIgraci(new ArrayList<>(igraci));
			
		}
		}
		
		return reprezentacija;
	}

}
