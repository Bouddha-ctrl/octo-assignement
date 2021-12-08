package ma.octo.assignement.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.exceptions.VersementNonExistantException;
import ma.octo.assignement.mapper.VersementMapper;
import ma.octo.assignement.service.IVersementService;
import ma.octo.assignement.service.imp.VersementServiceImp;

@RestController(value = "versements")
@RequestMapping("/versement")

public class VersementController {

    Logger LOGGER = LoggerFactory.getLogger(VersementController.class);

	@Autowired
	IVersementService versementService;
	
	
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public List<VersementDto> loadAllVersement() {
		 return versementService.loadAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public VersementDto loadOneVersement(@PathVariable Long id) throws VersementNonExistantException {
		 return versementService.loadOne(id);
	}
	
	@PostMapping("/executerVersements")
    @ResponseStatus(HttpStatus.CREATED)   //return Object: errorResponse or VersementDto
    public Object createTransaction(@RequestBody VersementDto versementDto) throws CompteNonExistantException, TransactionException{
		
		return versementService.createTransaction(versementDto);


	}
}
