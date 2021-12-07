package ma.octo.assignement.repository;

import ma.octo.assignement.domain.Compte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
  
  Compte findByRib(String rib);    
}
	