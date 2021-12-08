package ma.octo.assignement.service;

import java.util.List;

import ma.octo.assignement.domain.Audit;

public interface IAuditService {
	
	void auditVirement(String message);
	void auditVersement(String message);
	
	List<Audit> loadAll();

	List<Audit> loadVirement();
	List<Audit> loadVersement();
}
