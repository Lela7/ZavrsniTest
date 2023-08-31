package Sablon.Test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Id - identifikator
//Ime - tekstualna vrednost, obavezna
//Prezime - tekstualna vrednost, obavezna
//Postignuti golovi - celobrojna vrednost
@Entity
public class Igrac {
	


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column(nullable=false)
	private String ime;
	
	@Column(nullable=false)
	private String prezime;
	
	@ManyToOne
	private Reprezentacija reprezentacija;
	
	@Column
	private int brojGolova;

	public Igrac(Long id, String ime, String prezime, int brojGolova) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brojGolova = brojGolova;
	}
	
	
	public Igrac() {
		
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

	
	public Reprezentacija getReprezentacija() {
		return reprezentacija;
	}


	public void setReprezentacija(Reprezentacija reprezentacija) {
		this.reprezentacija = reprezentacija;
	}


	@Override
	public String toString() {
		return "Igrac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", reprezentacija=" + reprezentacija.getNaziv()
				+ ", brojGolova=" + brojGolova + "]";
	}


//	@Override
//	public String toString() {
//		return "Igrac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", brojGolova=" + brojGolova + "]";
//	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Igrac other = (Igrac) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
