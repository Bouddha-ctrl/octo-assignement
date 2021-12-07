package ma.octo.assignement.service.imp;

import ma.octo.assignement.domain.AuditVirement;
import ma.octo.assignement.domain.util.EventType;
import ma.octo.assignement.repository.AuditVirementRepository;
import ma.octo.assignement.service.IAuditService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuditService implements IAuditService{

    Logger LOGGER = LoggerFactory.getLogger(AuditService.class);

    @Autowired
    private AuditVirementRepository auditVirementRepository;
    @Autowired
    private AuditVirementRepository auditVersementRepository;

    
    @Override
	public void auditVirement(String message) {

        LOGGER.info("Audit de l'événement {}", EventType.VIREMENT);

        AuditVirement audit = new AuditVirement();
        audit.setEventType(EventType.VIREMENT);
        audit.setMessage(message);
        auditVirementRepository.save(audit);
    }

    @Override
    public void auditVersement(String message) {

        LOGGER.info("Audit de l'événement {}", EventType.VERSEMENT);

        AuditVirement audit = new AuditVirement();
        audit.setEventType(EventType.VERSEMENT);
        audit.setMessage(message);
        auditVersementRepository.save(audit);
    }




	
}
