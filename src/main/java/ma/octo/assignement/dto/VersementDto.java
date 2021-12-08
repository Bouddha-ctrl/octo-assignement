package ma.octo.assignement.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersementDto {
	 private Long id;
	 private String nom_emetteur;
	 private String prenom_emetteur;
	 
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	 private String rib;     //client to server
	 
	 @JsonProperty(access = JsonProperty.Access.READ_ONLY) 
	 private String nrCompteBeneficiaire; //server to client
	 
	 private String motifVersement;
	 
	 @JsonProperty(access = JsonProperty.Access.READ_ONLY) 
	 private Date dateExecution; //server to client
	 
	 private BigDecimal montantVersement;
}
