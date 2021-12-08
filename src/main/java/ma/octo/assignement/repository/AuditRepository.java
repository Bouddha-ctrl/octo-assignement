package ma.octo.assignement.repository;

import ma.octo.assignement.domain.Audit;
import ma.octo.assignement.domain.util.EventType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
	List<Audit> findByEventType(EventType eventType);
}
