package Sablon.Test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Sablon.Test.model.Igrac;
import Sablon.Test.service.IgracService;
import Sablon.Test.support.IgracDTOToIgrac;
import Sablon.Test.support.IgracToIgracDTO;
import Sablon.Test.web.dto.IgracDTO;


@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {
	
	@Autowired
	private IgracService igracService;
	
	@Autowired
	private IgracToIgracDTO toIgracDTO;
	
	@Autowired
	private IgracDTOToIgrac toIgrac;
	
	
	  // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<IgracDTO> getOne(@PathVariable Long id){
        Igrac igrac = igracService.findOne(id);

        if(igrac != null) {
            return new ResponseEntity<>(toIgracDTO.convert(igrac), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
  
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll(
			@RequestParam(required = false) String ime,
			@RequestParam(required = false) String prezime,
			@RequestParam(required = false) Integer brojGolova) {
		
		List<Igrac> igraci =igracService.findAll();
		return new ResponseEntity<>(toIgracDTO.convert(igraci),HttpStatus.OK);
		
	}
	
	
	


}
