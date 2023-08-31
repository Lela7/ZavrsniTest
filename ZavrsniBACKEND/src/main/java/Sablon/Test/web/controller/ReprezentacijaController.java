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


import Sablon.Test.model.Reprezentacija;
import Sablon.Test.service.ReprezentacijaService;
import Sablon.Test.support.ReprezentacijaDTOToReprezentacija;
import Sablon.Test.support.ReprezentacijaToReprezentacijaDTO;

import Sablon.Test.web.dto.ReprezentacijaDTO;

@RestController
@RequestMapping(value = "/api/reprezentacije", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReprezentacijaController {
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	@Autowired
	private ReprezentacijaToReprezentacijaDTO toReprezentacijaDTO;
	
	@Autowired
	private ReprezentacijaDTOToReprezentacija toReprezentacija;
	

	  // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
  @GetMapping("/{id}")
  public ResponseEntity<ReprezentacijaDTO> getOne(@PathVariable Long id){
      Reprezentacija reprezentacija = reprezentacijaService.findOne(id);

      if(reprezentacija != null) {
          return new ResponseEntity<>(toReprezentacijaDTO.convert(reprezentacija), HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  
  
  

	@GetMapping
	public ResponseEntity<List<ReprezentacijaDTO>> getAll(
			@RequestParam(required = false) String naziv,
			@RequestParam(required = false) String skraceniNaziv) {
		
		List<Reprezentacija> reprezentacije =reprezentacijaService.findAll();
		return new ResponseEntity<>(toReprezentacijaDTO.convert(reprezentacije),HttpStatus.OK);
		
	}
	
	

}
