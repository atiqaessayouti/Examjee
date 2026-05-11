package ma.enset.atiqaessayouti.locationvehicule.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class LocationDTO {
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private String nomClient;
    private Double prixTotal;
    private Long vehiculeId;
}