package ma.enset.atiqaessayouti.locationvehicule.services;

import ma.enset.atiqaessayouti.locationvehicule.dtos.*;
import java.util.List;

public interface ILocationService {
    List<VehiculeDTO> getVehiculesDisponibles();
    LocationDTO louerVehicule(LocationDTO locationDTO);
}