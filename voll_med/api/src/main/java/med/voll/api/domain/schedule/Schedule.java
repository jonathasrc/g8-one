package med.voll.api.domain.schedule;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medical.Medical;
import med.voll.api.domain.patient.Patient;

import java.time.LocalDateTime;

@Table(name = "Consultations")
@Entity(name = "Consultation")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_id")
    private Medical medical;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime date;

    @Column(name = "reason_cancel")
    @Enumerated(EnumType.STRING)
    private ReasonCancellation reason;

    public void cancel(ReasonCancellation reason) {
        this.reason = reason;
    }

}
