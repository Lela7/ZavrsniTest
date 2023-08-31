package Sablon.Test.web.dto;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;



public class ReprezentacijaDTO {
	

	@Positive(message = "Id mora biti pozitivan broj.")
	 private Long id;
	
	@NotBlank
	private String naziv;
	
	@NotBlank
	@Size(min=3, max=3)
	private String skraceniNaziv;
	
	
	private List <IgracDTO> igraci= new ArrayList<>();
	
	public ReprezentacijaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public List<IgracDTO> getIgraci() {
		return igraci;
	}

	public void setIgraci(List<IgracDTO> igraci) {
		this.igraci = igraci;
	}
	
	
	
	
	
	

}
