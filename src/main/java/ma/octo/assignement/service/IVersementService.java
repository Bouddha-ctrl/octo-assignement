package ma.octo.assignement.service;

import java.util.List;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;

public interface IVersementService {
	
	void createTransaction(VersementDto versementDto) throws CompteNonExistantException, TransactionException;
	List<Versement> loadAll();

}
