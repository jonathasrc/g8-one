package med.voll.api.domain.medical;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<Medical, Long> {
    Page<Medical> findAllByActiveTrue(Pageable pageable);
}
