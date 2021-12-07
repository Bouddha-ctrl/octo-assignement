package ma.octo.assignement.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.repository.UtilisateurRepository;
import ma.octo.assignement.service.IUtilisateurService;
@Service
@Transactional
public class UtilisateurServiceImp implements IUtilisateurService{

	
	@Autowired
	private UtilisateurRepository UserRepo;
	
	@Override
	public Utilisateur add(Utilisateur utilisateur) {
		//Traitement not required in the assignment
		
		return UserRepo.save(utilisateur);
	}

	@Override
	public List<Utilisateur> loadAll() {
		List<Utilisateur> list = UserRepo.findAll();
		
		if (CollectionUtils.isEmpty(list)) 
		{
			return null;	
		}

		return UserRepo.findAll();
	}

}
