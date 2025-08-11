package med.voll.api.domain.schedule;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medical.SpecialityMedical;

import java.time.LocalDateTime;

public record AppointmentSchedulingDTO(
        Long idMedico,
        @NotNull
        Long idPatient,
        @NotNull
        @Future
        LocalDateTime date,
        SpecialityMedical speciality
) {}
