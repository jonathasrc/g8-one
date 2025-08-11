package med.voll.api.domain.schedule;

import jakarta.validation.constraints.NotNull;

public record CancelAppointmentScheduleDTO(
        @NotNull
        Long idConsulta,
        @NotNull
        ReasonCancellation reason
) {}
