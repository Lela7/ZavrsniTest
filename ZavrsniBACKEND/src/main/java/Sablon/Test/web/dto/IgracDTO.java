package Sablon.Test.web.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class IgracDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	

	@NotNull
	
	private String ime;
	
	@NotNull
	private String prezime;
	
	
	private int brojGolova;
	
	//reprezentacijaNaziv i reprezentacijaId sam dodala naknadno,jer pokusavam da igracu dodelim reprezentaciju, dodala sam i u bazi
	private Long reprezentacijaId;
	private String reprezentacijaNaziv;
	
	
	


public IgracDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	public int getBrojGolova() {
		return brojGolova;
	}

	public void setBrojGolova(int brojGolova) {
		this.brojGolova = brojGolova;
	}
	public String getReprezentacijaNaziv() {
		return reprezentacijaNaziv;
	}

	public void setReprezentacijaNaziv(String reprezentacijaNaziv) {
		this.reprezentacijaNaziv = reprezentacijaNaziv;
	}

	public Long getReprezentacijaId() {
		return reprezentacijaId;
	}

	public void setReprezentacijaId(Long reprezentacijaId) {
		this.reprezentacijaId = reprezentacijaId;
	}

	
	

}
