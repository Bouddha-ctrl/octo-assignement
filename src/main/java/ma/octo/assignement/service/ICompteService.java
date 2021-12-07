package ma.octo.assignement.service;

import java.util.List;

import ma.octo.assignement.domain.Compte;

public interface ICompteService {
	
	Compte add(Compte compte);
	List<Compte> loadAll();
	
}
