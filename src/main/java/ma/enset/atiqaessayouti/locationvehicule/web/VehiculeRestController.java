package ma.enset.atiqaessayouti.locationvehicule.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.enset.atiqaessayouti.locationvehicule.dtos.LocationDTO;
import ma.enset.atiqaessayouti.locationvehicule.dtos.VehiculeDTO;
import ma.enset.atiqaessayouti.locationvehicule.services.ILocationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@AllArgsConstructor
@CrossOrigin("*")
@Tag(name = "2. Gestion des Véhicules et Locations", description = "APIs pour louer et rechercher des véhicules")
public class VehiculeRestController {

    private ILocationService locationService;

    @Operation(summary = "Véhicules disponibles", description = "Retourne uniquement les véhicules prêts à être loués")
    @GetMapping("/disponibles")
    @PreAuthorize("hasAnyRole('CLIENT', 'EMPLOYE', 'ADMIN')")
    public List<VehiculeDTO> getVehiculesDisponibles() {
        return locationService.getVehiculesDisponibles();
    }

    @Operation(summary = "Louer un véhicule", description = "Crée une location et transforme le statut du véhicule en LOUE")
    @PostMapping("/louer")
    @PreAuthorize("hasRole('CLIENT')")
    public LocationDTO louerVehicule(@RequestBody LocationDTO locationDTO) {
        return locationService.louerVehicule(locationDTO);
    }
}