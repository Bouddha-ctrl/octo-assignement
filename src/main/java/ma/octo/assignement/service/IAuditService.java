package ma.octo.assignement.service;

public interface IAuditService {
	
	void auditVirement(String message);
	void auditVersement(String message);

}
