package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.service.IUtilisateurService;

@RestController(value = "utilisateurs")
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private IUtilisateurService userService;
	
	
	@GetMapping("/list")
	List<Utilisateur> loadAll(){
    	return userService.loadAll();
	}
}
