package Sablon.Test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	
	Optional<Korisnik> findFirstByKorisnickoIme(String korisnickoIme);
}
