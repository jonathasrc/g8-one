package med.voll.api.domain.schedule;

import java.time.LocalDateTime;

public record DataConsultationSchedule(
        Long id, Long idMedico, Long idPatient, LocalDateTime date) {
    public DataConsultationSchedule(Schedule schedule){
        this(schedule.getId(), schedule.getMedical().getId(), schedule.getPatient().getId(), schedule.getDate());
    }
}