package ma.enset.atiqaessayouti.locationvehicule.services;

import lombok.AllArgsConstructor;
import ma.enset.atiqaessayouti.locationvehicule.dtos.*;
import ma.enset.atiqaessayouti.locationvehicule.entities.*;
import ma.enset.atiqaessayouti.locationvehicule.enums.StatutVehicule;
import ma.enset.atiqaessayouti.locationvehicule.mappers.LocationMapper;
import ma.enset.atiqaessayouti.locationvehicule.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LocationServiceImpl implements ILocationService {

    private VehiculeRepository vehiculeRepository;
    private LocationRepository locationRepository;
    private LocationMapper mapper;

    @Override
    public List<VehiculeDTO> getVehiculesDisponibles() {
        return vehiculeRepository.findAll().stream()
                .filter(v -> v.getStatut() == StatutVehicule.DISPONIBLE)
                .map(mapper::fromVehicule)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO louerVehicule(LocationDTO locationDTO) {
        Vehicule vehicule = vehiculeRepository.findById(locationDTO.getVehiculeId())
                .orElseThrow(() -> new RuntimeException("Erreur : Véhicule introuvable"));

        if (vehicule.getStatut() != StatutVehicule.DISPONIBLE) {
            throw new RuntimeException("Erreur : Ce véhicule n'est pas disponible pour la location");
        }

        Location location = new Location();
        location.setDateDebut(locationDTO.getDateDebut());
        location.setDateFin(locationDTO.getDateFin());
        location.setNomClient(locationDTO.getNomClient());
        location.setPrixTotal(locationDTO.getPrixTotal());
        location.setVehicule(vehicule);

        Location savedLocation = locationRepository.save(location);


        vehicule.setStatut(StatutVehicule.LOUE);
        vehiculeRepository.save(vehicule);

        return mapper.fromLocation(savedLocation);
    }
}