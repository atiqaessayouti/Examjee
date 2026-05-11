package ma.enset.atiqaessayouti.locationvehicule.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.enset.atiqaessayouti.locationvehicule.dtos.AgenceDTO;
import ma.enset.atiqaessayouti.locationvehicule.dtos.VehiculeDTO;
import ma.enset.atiqaessayouti.locationvehicule.mappers.LocationMapper;
import ma.enset.atiqaessayouti.locationvehicule.repositories.AgenceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agences")
@AllArgsConstructor
@CrossOrigin("*")
@Tag(name = "1. Gestion des Agences", description = "APIs pour consulter les agences de location")
public class AgenceRestController {

    private AgenceRepository agenceRepository;
    private LocationMapper locationMapper;

    @Operation(summary = "Lister toutes les agences", description = "Retourne la liste de toutes les agences disponibles")
    @GetMapping
    public List<AgenceDTO> getAllAgences() {
        return agenceRepository.findAll().stream()
                .map(locationMapper::fromAgence)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Lister les véhicules d'une agence", description = "Retourne les voitures et motos d'une agence donnée")
    @GetMapping("/{id}/vehicules")
    public List<VehiculeDTO> getVehiculesByAgence(@PathVariable Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"))
                .getVehicules().stream()
                .map(locationMapper::fromVehicule)
                .collect(Collectors.toList());
    }
}