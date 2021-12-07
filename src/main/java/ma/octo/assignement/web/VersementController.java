package ma.octo.assignement.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.service.IVersementService;
import ma.octo.assignement.service.imp.VersementServiceImp;

@RestController(value = "versements")
@RequestMapping("/versement")

public class VersementController {

    Logger LOGGER = LoggerFactory.getLogger(VersementServiceImp.class);

	@Autowired
	IVersementService versementService;
	
	
	@GetMapping("/list")
	List<Versement> loadAllCompte() {
		 return versementService.loadAll();
	}
	
	@PostMapping("/executerVersements")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createTransaction(@RequestBody VersementDto versementDto){
		System.out.println("hole again");
		try {
			versementService.createTransaction(versementDto);
		}catch(CompteNonExistantException CN) 
		{

			return ResponseEntity
	                .status(HttpStatus.NOT_ACCEPTABLE)
	                .body(CN.getMessage());
			
		}catch(TransactionException TE)
		{

			return ResponseEntity
	                .status(HttpStatus.NOT_ACCEPTABLE)
	                .body(TE.getMessage());
			
		}catch(Exception e)
		{
			LOGGER.error(e.getMessage());
			return ResponseEntity
	                .status(HttpStatus.NOT_ACCEPTABLE)
	                .body(e.getMessage());
		}
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
}
