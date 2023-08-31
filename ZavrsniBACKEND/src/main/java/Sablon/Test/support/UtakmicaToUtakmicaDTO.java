package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Utakmica;
import Sablon.Test.service.ReprezentacijaService;
import Sablon.Test.service.UtakmicaService;
import Sablon.Test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDTO implements Converter<Utakmica, UtakmicaDTO>{
	
@Override
public UtakmicaDTO convert (Utakmica utakmica) {
	UtakmicaDTO utakmicaDTO= new UtakmicaDTO();
	
	utakmicaDTO.setId(utakmica.getId());
	utakmicaDTO.setBrA(utakmica.getBrA());
	utakmicaDTO.setBrB(utakmica.getBrB());
	utakmicaDTO.setReprezentacijaAId(utakmica.getReprezentacijaA().getId());
	utakmicaDTO.setReprezentacijaANaziv(utakmica.getReprezentacijaA().getNaziv());;
	utakmicaDTO.setReprezentacijaBId(utakmica.getReprezentacijaB().getId());
	utakmicaDTO.setReprezentacijaBNaziv(utakmica.getReprezentacijaB().getNaziv());
	
	return utakmicaDTO;
	
}

public List<UtakmicaDTO> convert(List<Utakmica> utakmice) {
	List<UtakmicaDTO> utakmiceDTO = new ArrayList<>();
	
	for (Utakmica utakmica: utakmice) {
		utakmiceDTO.add(convert(utakmica));
	}
	return utakmiceDTO;
	
}
}
	
