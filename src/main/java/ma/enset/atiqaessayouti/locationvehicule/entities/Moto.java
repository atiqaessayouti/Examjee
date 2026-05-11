package ma.enset.atiqaessayouti.locationvehicule.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.atiqaessayouti.locationvehicule.enums.TypeMoto;

@Entity
@DiscriminatorValue("MOTO")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Moto extends Vehicule {
    private Integer cylindree;

    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;

    private Boolean casqueInclus; // oui ou non
}