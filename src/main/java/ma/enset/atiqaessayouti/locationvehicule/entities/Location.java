package ma.enset.atiqaessayouti.locationvehicule.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String nomClient;
    private Double prixTotal;

    // كل كراء يخص مركبة واحدة فقط
    @ManyToOne
    private Vehicule vehicule;
}