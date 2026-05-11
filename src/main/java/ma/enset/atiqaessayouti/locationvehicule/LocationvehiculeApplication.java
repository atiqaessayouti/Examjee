package ma.enset.atiqaessayouti.locationvehicule;

import ma.enset.atiqaessayouti.locationvehicule.entities.*;
import ma.enset.atiqaessayouti.locationvehicule.enums.*;
import ma.enset.atiqaessayouti.locationvehicule.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class LocationvehiculeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationvehiculeApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AgenceRepository agenceRepository,
                            VehiculeRepository vehiculeRepository,
                            LocationRepository locationRepository) {
        return args -> {

            Agence agence1 = Agence.builder()
                    .nom("AutoRent Mohammedia")
                    .adresse("Boulevard Hassan II")
                    .ville("Mohammedia")
                    .telephone("0523001122")
                    .build();

            Agence agence2 = Agence.builder()
                    .nom("Premium Location Casa")
                    .adresse("Maarif")
                    .ville("Casablanca")
                    .telephone("0522334455")
                    .build();

            agenceRepository.save(agence1);
            agenceRepository.save(agence2);


            Voiture voiture = new Voiture();
            voiture.setMarque("Peugeot");
            voiture.setModele("208");
            voiture.setMatricule("1234-A-50");
            voiture.setPrixParJour(350.0);
            voiture.setDateMiseEnService(new Date());
            voiture.setStatut(StatutVehicule.DISPONIBLE);
            voiture.setAgence(agence1);
            voiture.setNombrePortes(5);
            voiture.setTypeCarburant(TypeCarburant.DIESEL);
            voiture.setBoiteVitesse(BoiteVitesse.MANUELLE);
            vehiculeRepository.save(voiture);


            Moto moto = new Moto();
            moto.setMarque("Yamaha");
            moto.setModele("TMAX");
            moto.setMatricule("9876-B-6");
            moto.setPrixParJour(500.0);
            moto.setDateMiseEnService(new Date());
            moto.setStatut(StatutVehicule.DISPONIBLE);
            moto.setAgence(agence2);
            moto.setCylindree(560);
            moto.setTypeMoto(TypeMoto.SCOOTER);
            moto.setCasqueInclus(true);
            vehiculeRepository.save(moto);


            Location location = Location.builder()
                    .dateDebut(new Date())
                    .dateFin(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 3))) // 3 أيام
                    .nomClient("Ahmed El Mansouri")
                    .prixTotal(350.0 * 3)
                    .vehicule(voiture)
                    .build();

            locationRepository.save(location);

            // تحديث حالة السيارة لتصبح مكرية
            voiture.setStatut(StatutVehicule.LOUE);
            vehiculeRepository.save(voiture);

            System.out.println("done");
        };
    }
}