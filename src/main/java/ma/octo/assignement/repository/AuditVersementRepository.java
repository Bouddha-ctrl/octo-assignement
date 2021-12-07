package ma.octo.assignement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.octo.assignement.domain.AuditVersement;

@Repository
public interface AuditVersementRepository extends JpaRepository<AuditVersement, Long> {
}