package ma.enset.atiqaessayouti.locationvehicule.repositories;

import ma.enset.atiqaessayouti.locationvehicule.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}