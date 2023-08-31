package Sablon.Test.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Sablon.Test.model.Reprezentacija;
import Sablon.Test.model.Utakmica;
import Sablon.Test.service.ReprezentacijaService;
import Sablon.Test.service.UtakmicaService;
import Sablon.Test.support.UtakmicaDTOToUtakmica;
import Sablon.Test.support.UtakmicaToUtakmicaDTO;

import Sablon.Test.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value = "/api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
public class UtakmicaController {
	
	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired
	private UtakmicaToUtakmicaDTO toUtakmicaDTO;
	
	@Autowired
	private UtakmicaDTOToUtakmica toUtakmica;
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<UtakmicaDTO> create(@Valid @RequestBody UtakmicaDTO utakmicaDTO){
		 
	    Utakmica utakmica = toUtakmica.convert(utakmicaDTO);
	    if(utakmica.getReprezentacijaA() == null || utakmica.getReprezentacijaB()==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
	    
	    
	    Utakmica sacuvanaUtakmica = utakmicaService.save(utakmica);
	    
	    return new ResponseEntity<>(toUtakmicaDTO.convert(sacuvanaUtakmica), HttpStatus.CREATED);
	    
	      }
	 
	 
		//@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<UtakmicaDTO> update(@PathVariable Long id, @Valid @RequestBody UtakmicaDTO utakmicaDTO){

	        if(!id.equals(utakmicaDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Utakmica utakmica = toUtakmica.convert(utakmicaDTO);

	        if(utakmica.getReprezentacijaA() == null || utakmica.getReprezentacijaB()==null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	       Utakmica sacuvanaUtakmica = utakmicaService.update(utakmica);

	        return new ResponseEntity<>(toUtakmicaDTO.convert(sacuvanaUtakmica),HttpStatus.OK);
	    }

	    //gledala sam ProjekcijaController:
	    
	    
	   // @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
	        Utakmica obrisanaUtakmica = utakmicaService.delete(id);

	        if(obrisanaUtakmica != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    

	 // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	    @GetMapping("/{id}")
	    public ResponseEntity<UtakmicaDTO> getOne(@PathVariable Long id){
	       Utakmica utakmica = utakmicaService.findOne(id);

	        if(utakmica.getReprezentacijaA() != null && utakmica.getReprezentacijaB() != null) {
	            return new ResponseEntity<>(toUtakmicaDTO.convert(utakmica), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    
	    // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<UtakmicaDTO>> getAll(@RequestParam(required=false) Long reprezentacijaAId,
	    												@RequestParam(required=false) Long reprezentacijaBId,
	    												@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
	    	
	    	
	    	
	    Page<Utakmica> page;
	    
	    if(reprezentacijaAId != null && reprezentacijaBId != null) {
	    	page=utakmicaService.find(reprezentacijaAId, reprezentacijaBId, pageNo);
	    } else if (reprezentacijaAId!= null) {
	    	page=utakmicaService.findByReprezentacijaAId(reprezentacijaAId, pageNo);
	    } else if(reprezentacijaBId!=null) {
	    	page=utakmicaService.findByReprezentacijaBId(reprezentacijaBId, pageNo);
	    }
	
	    	
	    	else {
	    
	    	page=utakmicaService.findAll(pageNo);
	    }
//Milanovo resenje:
//	        Page<Utakmica> page;   
//        try{
//            Reprezentacija repA = reprezentacijaService.findOne(reprezentacijaAId);
//            Reprezentacija repB = reprezentacijaService.findOne(reprezentacijaBId);
//            if(repA != null && repB != null) {
//            page = utakmicaService.find(reprezentacijaAId, reprezentacijaBId, pageNo);
//            }else {
//            	page = utakmicaService.findAll(pageNo);
//            }
//        }catch (Exception e){
//            page = utakmicaService.findAll(pageNo);
//        }
        
        
        
        
        //ovo sam dodala 25/01/2023
//        if(reprezentacijaAId != null && reprezentacijaBId !=null {
//        	page=utakmicaService.find(reprezentacijaAId, reprezentacijaBId, pageNo);
//        } else {
//        	page=utakmicaService.findAll(pageNo);
//        }
        
        
        
        
        
	       
	        

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

	        return new ResponseEntity<>(toUtakmicaDTO.convert(page.getContent()), headers, HttpStatus.OK);
	    }
	    
	    @ExceptionHandler(value = DataIntegrityViolationException.class)
	    public ResponseEntity<Void> handle() {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 

	    
	        
	    }
	
	
	


