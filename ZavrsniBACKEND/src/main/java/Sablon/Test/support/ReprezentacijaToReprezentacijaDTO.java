package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Igrac;
import Sablon.Test.model.Reprezentacija;
import Sablon.Test.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDTO implements Converter<Reprezentacija,ReprezentacijaDTO >{

	
@Autowired
private IgracToIgracDTO igracToIgracDTO;
	
	@Override
	public ReprezentacijaDTO convert (Reprezentacija reprezentacija) {
		ReprezentacijaDTO reprezentacijaDTO = new ReprezentacijaDTO();
		
		reprezentacijaDTO.setId(reprezentacija.getId());
		reprezentacijaDTO.setNaziv(reprezentacija.getNaziv());
		reprezentacijaDTO.setSkraceniNaziv(reprezentacija.getSkraceniNaziv());
		List<Igrac> igraci= new ArrayList<>(reprezentacija.getIgraci());
		reprezentacijaDTO.setIgraci(new ArrayList<>(igracToIgracDTO.convert(igraci)));
		
		return reprezentacijaDTO;
	}

	public List<ReprezentacijaDTO> convert(List<Reprezentacija> reprezentacije) {
		List<ReprezentacijaDTO> reprezentacijeDTO=new ArrayList<>();
		
		for(Reprezentacija reprezentacija : reprezentacije) {
			reprezentacijeDTO.add(convert(reprezentacija));
		}
		return reprezentacijeDTO;
	}
}
