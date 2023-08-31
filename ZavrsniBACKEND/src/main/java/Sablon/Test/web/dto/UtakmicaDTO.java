package Sablon.Test.web.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import Sablon.Test.model.Reprezentacija;

public class UtakmicaDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	private int brA;

	private int brB;
	
	private String reprezentacijaANaziv;
	
	private String reprezentacijaBNaziv;
	
	private Long reprezentacijaAId;
	
	private Long reprezentacijaBId;
	
	public UtakmicaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrA() {
		return brA;
	}

	public void setBrA(int brA) {
		this.brA = brA;
	}

	public int getBrB() {
		return brB;
	}

	public void setBrB(int brB) {
		this.brB = brB;
	}

	public String getReprezentacijaANaziv() {
		return reprezentacijaANaziv;
	}

	public void setReprezentacijaANaziv(String reprezentacijaANaziv) {
		this.reprezentacijaANaziv = reprezentacijaANaziv;
	}

	public String getReprezentacijaBNaziv() {
		return reprezentacijaBNaziv;
	}

	public void setReprezentacijaBNaziv(String reprezentacijaBNaziv) {
		this.reprezentacijaBNaziv = reprezentacijaBNaziv;
	}

	public Long getReprezentacijaAId() {
		return reprezentacijaAId;
	}

	public void setReprezentacijaAId(Long reprezentacijaAId) {
		//03.03.2023.Izmenila sam sledeci red pokusavajuci da ne dobijem SRB SRB
		if(reprezentacijaAId != reprezentacijaBId)      //Kad pokusam da unesem SRB SRB izbaci mi u Postmanu 400 Bad Request
		this.reprezentacijaAId = reprezentacijaAId;
	}

	public Long getReprezentacijaBId() {
		return reprezentacijaBId;
	}

	public void setReprezentacijaBId(Long reprezentacijaBId) {
		//03.03.2023.Izmenila sam sledeci red pokusavajuci da ne dobijem SRB SRB da igra
		if(reprezentacijaBId != reprezentacijaAId)
		this.reprezentacijaBId = reprezentacijaBId;
	}
	
	
	

}
