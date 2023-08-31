INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (1, 'SRBIJA', 'SRB');      
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (2, 'SVAJCARSKA', 'SVA'); 
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (3, 'KAMERUN', 'KAM'); 
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (4, 'BRAZIL', 'BRA'); 





INSERT INTO utakmica(id, brA, brB, reprezentacijaa_id, reprezentacijab_id) VALUES(1, 1, 2 ,1, 2);
INSERT INTO utakmica(id, brA, brB, reprezentacijaa_id, reprezentacijab_id) VALUES(2, 3, 2 ,1,3);
INSERT INTO utakmica(id, brA, brB, reprezentacijaa_id, reprezentacijab_Id) VALUES(3, 1, 2 ,2,3);
INSERT INTO utakmica(id, brA, brB, reprezentacijaa_id, reprezentacijab_id) VALUES(4, 2, 2 ,3,4);

--Ovde u igrac sam dodala reprezentacija_id, jer pokusavam da resim zadatak pod 3.Verovatno mora i reprezentacija da ima svoju listu igraca...
INSERT INTO igrac (id, ime, prezime, broj_golova, reprezentacija_id) VALUES(1, 'Milan', 'Peric', 19, 1);
INSERT INTO igrac (id, ime, prezime, broj_golova, reprezentacija_id) VALUES(2, 'Milanko', 'Pericic', 23, 2);
INSERT INTO igrac (id, ime, prezime, broj_golova, reprezentacija_id)VALUES(3, 'Mili', 'Petrovic', 30, 3);
INSERT INTO igrac (id, ime, prezime, broj_golova, reprezentacija_id) VALUES(4, 'Bogdan', 'Jankovic', 11, 1);
INSERT INTO igrac (id, ime, prezime, broj_golova, reprezentacija_id) VALUES(5, 'Igor', 'Misic', 40, 4);