package ma.octo.assignement.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.octo.assignement.domain.Compte;

@Data
@NoArgsConstructor
public class VersementDto {
	
	 private String nom_emetteur;
	 private String prenom_emetteur;
	 private String rib;
	 private String motifVersement;
	 private Date dateExecution;
	 private BigDecimal montantVersement;
}
