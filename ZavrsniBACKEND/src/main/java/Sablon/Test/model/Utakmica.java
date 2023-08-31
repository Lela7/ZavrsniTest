package Sablon.Test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Id - identifikator
//Reprezentacija A - veza do reprezentacije
//Reprezentacija B - veza do reprezentacije
//Broj golova A - celobrojna vrednost
//Broj golova B - celobrojna vrednost
@Entity
public class Utakmica {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Column
	private int brA;
	@Column
	private int brB;
	@ManyToOne
	private Reprezentacija reprezentacijaA;
	@ManyToOne
	private Reprezentacija reprezentacijaB;
	
	
	public Utakmica(Long id, int brA, int brB, Reprezentacija reprezentacijaA, Reprezentacija reprezentacijaB) {
		super();
		this.id = id;
		this.brA = brA;
		this.brB = brB;
		this.reprezentacijaA = reprezentacijaA;
		this.reprezentacijaB = reprezentacijaB;
	}
	
	public Utakmica() {
		
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

	public Reprezentacija getReprezentacijaA() {
		return reprezentacijaA;
	}

	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
		this.reprezentacijaA = reprezentacijaA;
		if(reprezentacijaA !=null && !reprezentacijaA.getUtakmiceA().contains(this)){
            reprezentacijaA.getUtakmiceA().add(this);
        }
	}
	
	//03.03.2023. Dve razlicite reprezentacije igraju u okviru jedne utakmice:
	
//	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
//		this.reprezentacijaA = reprezentacijaA;
//		if(reprezentacijaA !=null && reprezentacijaA != reprezentacijaB && !reprezentacijaA.getUtakmiceA().contains(this)){
//            reprezentacijaA.getUtakmiceA().add(this);
//        }
//	}
	
	//Ovo iznad ne funkcionise.
	
	public Reprezentacija getReprezentacijaB() {
		return reprezentacijaB;
	}

	public void setReprezentacijaB (Reprezentacija reprezentacijaB) {
		this.reprezentacijaB=reprezentacijaB;
	
		if(reprezentacijaB !=null &&!reprezentacijaB.getUtakmiceB().contains(this)){
            reprezentacijaB.getUtakmiceB().add(this);
        }
	
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

//	public Reprezentacija getReprezentacijaA() {
//		return reprezentacijaA;
//	}
//
//	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
//		this.reprezentacijaA = reprezentacijaA;
//	}
//
//	public Reprezentacija getReprezentacijaB() {
//		return reprezentacijaB;
//	}
//
//	public void setReprezentacijaB(Reprezentacija reprezentacijaB) {
//		this.reprezentacijaB = reprezentacijaB;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utakmica other = (Utakmica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//pokusavam da izmenim ovaj toString:
	
//	@Override
//	public String toString() {
//		return "Utakmica [id=" + id + ", brA=" + brA + ", brB=" + brB + ", reprezentacijaA=" + reprezentacijaA
//				+ ", reprezentacijaB=" + reprezentacijaB + "]";
//	}
	
	//izmena 6/2/2023:
	
	@Override
	public String toString() {
		return "Utakmica [id=" + id + ", brA=" + brA + ", brB=" + brB + ", reprezentacijaA=" + getReprezentacijaA().getNaziv()
				+ ", reprezentacijaB=" + getReprezentacijaB().getNaziv() + "]";
	}
	
	
	
	
	
	
	
}

	