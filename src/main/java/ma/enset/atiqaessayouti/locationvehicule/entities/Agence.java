package ma.enset.atiqaessayouti.locationvehicule.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private String telephone;


    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Vehicule> vehicules;
}