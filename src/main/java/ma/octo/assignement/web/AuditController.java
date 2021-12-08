package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Audit;
import ma.octo.assignement.service.IAuditService;

@RestController(value = "audits")
@RequestMapping("/audit")
public class AuditController {
	
	@Autowired
	private IAuditService auditService;
	
	
	@GetMapping("/list")
	List<Audit> loadAll(@RequestParam(defaultValue = "all") String type) 
	{
		if (type.equals("all"))            return auditService.loadAll();
		if (type.equals("virement"))       return auditService.loadVirement();
		if (type.equals("versement"))      return auditService.loadVersement();
		
		return null;
	    
	}
}
