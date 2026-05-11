package ma.enset.atiqaessayouti.locationvehicule.repositories;

import ma.enset.atiqaessayouti.locationvehicule.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}