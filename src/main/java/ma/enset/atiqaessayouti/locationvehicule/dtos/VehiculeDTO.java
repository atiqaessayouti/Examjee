package ma.enset.atiqaessayouti.locationvehicule.dtos;

import lombok.Data;

@Data
public class VehiculeDTO {
    private Long id;
    private String marque;
    private String modele;
    private Double prixParJour;
    private String statut;
    private String typeVehicule; // كنزيدوه باش الواجهة تعرف واش هادي VOITURE ولا MOTO
}