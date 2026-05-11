package ma.enset.atiqaessayouti.locationvehicule.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.enset.atiqaessayouti.locationvehicule.enums.StatutVehicule;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_VEHICULE", length = 15)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private Double prixParJour;

    @Temporal(TemporalType.DATE)
    private Date dateMiseEnService;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;


    @ManyToOne
    private Agence agence;


    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Location> locations;
}