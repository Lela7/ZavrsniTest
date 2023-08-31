package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Utakmica;
import Sablon.Test.service.ReprezentacijaService;
import Sablon.Test.service.UtakmicaService;
import Sablon.Test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDTOToUtakmica implements Converter<UtakmicaDTO, Utakmica>{
	
	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	@Override
	
	public Utakmica convert (UtakmicaDTO dto) {
		Utakmica utakmica;
		
		if(dto.getId()==null) {
			utakmica = new Utakmica ();
		} else {
			utakmica=utakmicaService.findOne(dto.getId());
		}
		
		if(utakmica != null) {
			utakmica.setBrA(dto.getBrA());
			utakmica.setBrB(dto.getBrB());
			utakmica.setReprezentacijaA(reprezentacijaService.findOne(dto.getReprezentacijaAId()));
			utakmica.setReprezentacijaB(reprezentacijaService.findOne(dto.getReprezentacijaBId()));
		}
		
		return utakmica;
	}

}
