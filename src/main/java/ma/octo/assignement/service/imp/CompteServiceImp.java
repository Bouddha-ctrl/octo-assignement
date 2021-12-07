package ma.octo.assignement.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.repository.CompteRepository;
import ma.octo.assignement.service.ICompteService;

@Service
@Transactional
public class CompteServiceImp implements ICompteService{
	
	@Autowired
	private CompteRepository comptRepo;
	
	
	@Override
	public Compte add(Compte compte) {
		//Traitement not required in the assignment
		return comptRepo.save(compte);
	}

	@Override
	public List<Compte> loadAll() {
		List<Compte> list = comptRepo.findAll();
		
		if (CollectionUtils.isEmpty(list)) 
		{
			return null;	
		}
		
		return comptRepo.findAll();
	}


}
