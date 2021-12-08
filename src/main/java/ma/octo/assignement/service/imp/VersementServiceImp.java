package ma.octo.assignement.service.imp;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.exceptions.VersementNonExistantException;
import ma.octo.assignement.mapper.VersementMapper;
import ma.octo.assignement.repository.CompteRepository;
import ma.octo.assignement.repository.VersementRepository;
import ma.octo.assignement.service.IAuditService;
import ma.octo.assignement.service.IVersementService;

@Service
@Transactional
public class VersementServiceImp implements IVersementService{

    Logger LOGGER = LoggerFactory.getLogger(VersementServiceImp.class);

	@Autowired
	private VersementRepository versementRepo;
	@Autowired 
	private CompteRepository compteRepo;
	@Autowired
	private IAuditService auditService;
	
	
	@Override
	public VersementDto createTransaction(VersementDto versementDto) throws CompteNonExistantException, TransactionException
	{
		LOGGER.debug("versement creation");
		Compte compteB = compteRepo.findByRib(versementDto.getRib()); //compte Beneficiaire
		
		if (compteB == null) 
		{
			LOGGER.info("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }
		if (versementDto.getMontantVersement().equals(null) || versementDto.getMontantVersement().signum() == 0) 
		{
			LOGGER.info("Montant vide");
            throw new TransactionException("Montant vide");
        } 
		if (versementDto.getMontantVersement().equals(null) || versementDto.getMontantVersement().signum() == -1) 
		{
			LOGGER.info("Montant Negatif");
            throw new TransactionException("Montant Negatif");
        } 
		
		if (versementDto.getMontantVersement().intValue() < 10) 
		{
			LOGGER.info("Montant minimal de versement non atteint");
            throw new TransactionException("Montant minimal de versement non atteint");
        } 
		if (versementDto.getMotifVersement().isBlank()) {
			LOGGER.info("Motif vide");
            throw new TransactionException("Motif vide");
        }
		if (versementDto.getNom_emetteur() == null || versementDto.getNom_emetteur().isBlank()) 
		{
			LOGGER.info("Nom_emetteur vide");
            throw new TransactionException("Nom_emetteur vide");
        }
		if (versementDto.getPrenom_emetteur() == null || versementDto.getPrenom_emetteur().isBlank()) 
		{
			LOGGER.info("Prenom_emetteur vide");
            throw new TransactionException("Prenom_emetteur vide");
        }
		
		compteB.ajoutSolde(versementDto.getMontantVersement());
		try {
			compteRepo.save(compteB);
		}catch(ObjectOptimisticLockingFailureException e) {
			LOGGER.warn("Acces concurrent, resseyer ultérieurement ");
			throw new TransactionException("Acces concurrent, resseyer ultérieurement");	
		}
		
		Versement versement = new Versement();
		versement.setCompteBeneficiaire(compteB);
		versement.setDateExecution(new Date());   //Versement exacution date, initialized the first time in the server
		versement.setMontantVersement(versementDto.getMontantVersement());
		versement.setMotifVersement(versementDto.getMotifVersement());
		versement.setNom_emetteur(versementDto.getNom_emetteur());
		versement.setPrenom_emetteur(versementDto.getPrenom_emetteur());
		
		Versement ver = versementRepo.save(versement);
		LOGGER.debug("versement created");

		auditService.auditVersement("Versement depuis " + versementDto.getNom_emetteur()+" "+versementDto.getPrenom_emetteur() +
				" vers " + compteB.getNrCompte() + " d'un montant de " + versementDto.getMontantVersement()
                 .toString());
		
		return VersementMapper.map(ver);
	}

	@Override
	public List<VersementDto> loadAll() 
	{
		LOGGER.debug("loadAll versement");
		List<Versement> all = versementRepo.findAll();
		
		if (CollectionUtils.isEmpty(all)) 
		{
			return null;	
		}

		return all.stream().map(VersementMapper::map)  //Versement -> VersementDto
				.collect(Collectors.toList());
	}

	@Override
	public VersementDto loadOne(Long id) throws VersementNonExistantException {
		LOGGER.debug("loadOne versement");

		try {
			Versement versement = versementRepo.findById(id).get();
			return VersementMapper.map(versement);

		}catch(NoSuchElementException e) 
		{
			LOGGER.info("Versement Non existant");
            throw new VersementNonExistantException("Versement Non existant");
		}
			
	}

	

}
