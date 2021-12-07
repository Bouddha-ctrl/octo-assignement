package ma.octo.assignement.mapper;

import java.math.BigDecimal;
import java.util.Date;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;

public class VersementMapper {
	
    public static VersementDto versementDto;

    public static VersementDto map(Versement versement){
        versementDto = new VersementDto();
        versementDto.setRib(versement.getCompteBeneficiaire().getRib());
        versementDto.setNom_emetteur(versement.getNom_emetteur());
        versementDto.setPrenom_emetteur(versement.getPrenom_emetteur());
        versementDto.setDateExecution(versement.getDateExecution());
        
        return versementDto;
    }
}
