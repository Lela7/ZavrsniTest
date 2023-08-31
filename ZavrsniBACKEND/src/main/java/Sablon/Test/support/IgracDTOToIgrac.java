package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Igrac;
import Sablon.Test.service.IgracService;
import Sablon.Test.service.ReprezentacijaService;
import Sablon.Test.web.dto.IgracDTO;

@Component
public class IgracDTOToIgrac implements Converter<IgracDTO, Igrac>{
	
	@Autowired
	private IgracService igracService;
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	@Override
	public Igrac convert (IgracDTO dto) {
		Igrac igrac;
		
		if(dto.getId()==null) {
			igrac= new Igrac();
		}else {
			igrac=igracService.findOne(dto.getId());
		}
		
		if (igrac != null) {
			igrac.setIme(dto.getIme());
			igrac.setPrezime(dto.getPrezime());
			igrac.setBrojGolova(dto.getBrojGolova());
			igrac.setReprezentacija(reprezentacijaService.findOne(dto.getReprezentacijaId()));
		}
		
		return igrac;
	}

}
