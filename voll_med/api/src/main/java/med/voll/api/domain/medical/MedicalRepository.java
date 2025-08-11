package med.voll.api.domain.medical;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicalRepository extends JpaRepository<Medical, Long> {
    Page<Medical> findAllByActiveTrue(Pageable pageable);

    @Query("""
            SELECT m from medical m WHERE  m.active = true and m.speciality = :speciality
             and m.id not in (SELECT c.medical.id FROM Consultation c WHERE c.date = :date)
             order by rand() limit 1
            """)
    Medical chooseRandomDoctorOnDate(SpecialityMedical speciality, @NotNull @Future LocalDateTime date);
}
