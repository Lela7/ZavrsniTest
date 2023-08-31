package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Igrac;
import Sablon.Test.web.dto.IgracDTO;

@Component
public class IgracToIgracDTO implements Converter<Igrac, IgracDTO>{
	
	@Override
	public IgracDTO convert(Igrac igrac) {
		IgracDTO igracDTO = new IgracDTO();
		
		igracDTO.setId(igrac.getId());
		igracDTO.setIme(igrac.getIme());
		igracDTO.setPrezime(igrac.getPrezime());
		igracDTO.setBrojGolova(igrac.getBrojGolova());
		igracDTO.setReprezentacijaId(igrac.getReprezentacija().getId());
		igracDTO.setReprezentacijaNaziv(igrac.getReprezentacija().getNaziv());
		
		return igracDTO;
	}
	
	public List<IgracDTO> convert (List<Igrac> igraci) {
		List<IgracDTO> igraciDTO = new ArrayList<>();
		
		for(Igrac igrac: igraci) {
			igraciDTO.add(convert(igrac));
		}
		
		return igraciDTO;
	}

}
