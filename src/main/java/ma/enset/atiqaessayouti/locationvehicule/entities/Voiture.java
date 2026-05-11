package ma.enset.atiqaessayouti.locationvehicule.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.atiqaessayouti.locationvehicule.enums.*;

@Entity
@DiscriminatorValue("VOITURE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Voiture extends Vehicule {
    private Integer nombrePortes;

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;
}