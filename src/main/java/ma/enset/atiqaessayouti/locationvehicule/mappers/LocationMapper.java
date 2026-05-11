package ma.enset.atiqaessayouti.locationvehicule.mappers;

import ma.enset.atiqaessayouti.locationvehicule.dtos.*;
import ma.enset.atiqaessayouti.locationvehicule.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper {

    public AgenceDTO fromAgence(Agence agence) {
        AgenceDTO dto = new AgenceDTO();
        BeanUtils.copyProperties(agence, dto);
        return dto;
    }

    public VehiculeDTO fromVehicule(Vehicule vehicule) {
        VehiculeDTO dto = new VehiculeDTO();
        BeanUtils.copyProperties(vehicule, dto);
        dto.setStatut(vehicule.getStatut().name());

        // تحديد نوع المركبة للواجهة
        if (vehicule instanceof Voiture) {
            dto.setTypeVehicule("VOITURE");
        } else if (vehicule instanceof Moto) {
            dto.setTypeVehicule("MOTO");
        }
        return dto;
    }

    public LocationDTO fromLocation(Location location) {
        LocationDTO dto = new LocationDTO();
        BeanUtils.copyProperties(location, dto);
        if (location.getVehicule() != null) {
            dto.setVehiculeId(location.getVehicule().getId());
        }
        return dto;
    }
}