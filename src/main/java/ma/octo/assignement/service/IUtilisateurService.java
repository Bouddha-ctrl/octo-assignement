package ma.octo.assignement.service;

import java.util.List;

import ma.octo.assignement.domain.Utilisateur;

public interface IUtilisateurService {
	
	Utilisateur add(Utilisateur utilisateur);
	List<Utilisateur> loadAll();

}
