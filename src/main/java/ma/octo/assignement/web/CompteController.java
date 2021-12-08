package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.service.ICompteService;

@RestController(value = "comptes")
@RequestMapping("/compte")
public class CompteController {

	@Autowired
	private ICompteService compteService;
	
	
	@GetMapping("/list")
	List<Compte> loadAll() {
	    return compteService.loadAll();
	}
}
