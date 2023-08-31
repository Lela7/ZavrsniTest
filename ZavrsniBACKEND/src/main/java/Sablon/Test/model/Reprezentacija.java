package Sablon.Test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

//
//Reprezentacija:
//Id - identifikator
//Naziv - tekstualna vrednost, obavezna, jedinstvena
//Skraceni naziv - tekstualna vrednost, obavezna, jedinstvena, troslovna
//oznaka
//Igraci - lista igrača koji igraju za ovu reprezentaciju
@Entity
public class Reprezentacija {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column(nullable=false, unique=true)
	private String naziv;
	
	@Column(nullable=false, unique=true, length=3)
	private String skraceniNaziv;
	
	@OneToMany(mappedBy = "reprezentacija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Igrac> igraci=new ArrayList<>();
	

	
	@OneToMany(mappedBy = "reprezentacijaA", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Utakmica> utakmiceA=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "reprezentacijaB", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Utakmica> utakmiceB=new ArrayList<>();


	public Reprezentacija(Long id, String naziv, String skraceniNaziv, List<Igrac> igraci, List<Utakmica> utakmiceA,
			List<Utakmica> utakmiceB) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.igraci = igraci;
		this.utakmiceA = utakmiceA;
		this.utakmiceB = utakmiceB;
	}
	
	public Reprezentacija() {
		
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

	public List<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}

	public List<Utakmica> getUtakmiceA() {
		return utakmiceA;
	}

	public void setUtakmiceA(List<Utakmica> utakmiceA) {
		this.utakmiceA = utakmiceA;
	}

	public List<Utakmica> getUtakmiceB() {
		return utakmiceB;
	}

	public void setUtakmiceB(List<Utakmica> utakmiceB) {
		this.utakmiceB = utakmiceB;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reprezentacija other = (Reprezentacija) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Reprezentacija [id=" + id + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv + ", utakmiceA="
//				+ utakmiceA + ", utakmiceB=" + utakmiceB + "]";
//	}

//	@Override
//	public String toString() {
//		return "Reprezentacija [id=" + id + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv + ", igraci="
//				+ igraci + "]";
//	}
	
	
	@Override
	public String toString() {
		return "Reprezentacija [id=" + id + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv +  "]";
	}
	
	
	
	
	
	
	

}
