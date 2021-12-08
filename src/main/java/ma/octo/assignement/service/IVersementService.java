package ma.octo.assignement.service;

import java.util.List;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.exceptions.VersementNonExistantException;

public interface IVersementService {
	
	VersementDto loadOne(Long id) throws VersementNonExistantException;
	VersementDto createTransaction(VersementDto versementDto) throws CompteNonExistantException, TransactionException;
	List<VersementDto> loadAll();

}
