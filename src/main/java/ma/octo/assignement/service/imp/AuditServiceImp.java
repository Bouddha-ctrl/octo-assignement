package ma.octo.assignement.service.imp;

import ma.octo.assignement.domain.Audit;
import ma.octo.assignement.domain.util.EventType;
import ma.octo.assignement.repository.AuditRepository;
import ma.octo.assignement.service.IAuditService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuditServiceImp implements IAuditService{

    Logger LOGGER = LoggerFactory.getLogger(AuditServiceImp.class);

    @Autowired
    private AuditRepository auditRepository;

    @Override
	public void auditVirement(String message) {

        LOGGER.info("Audit de l'événement {}", EventType.VIREMENT);

        Audit audit = new Audit();
        audit.setEventType(EventType.VIREMENT);
        audit.setMessage(message);
        auditRepository.save(audit);
    }

    @Override
    public void auditVersement(String message) {

        LOGGER.info("Audit de l'événement {}", EventType.VERSEMENT);

        Audit audit = new Audit();
        audit.setEventType(EventType.VERSEMENT);
        audit.setMessage(message);
        auditRepository.save(audit);
    }

	@Override
	public List<Audit> loadAll() {
        LOGGER.debug("loadAll audits");
		return auditRepository.findAll();
	}

	@Override
	public List<Audit> loadVirement() {
		
		return auditRepository.findByEventType(EventType.VIREMENT);
	}

	@Override
	public List<Audit> loadVersement() {

		return auditRepository.findByEventType(EventType.VERSEMENT);
	}

	



	
}
