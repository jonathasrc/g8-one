package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.schedule.AppointmentSchedulingDTO;
import med.voll.api.domain.schedule.CancelAppointmentScheduleDTO;
import med.voll.api.domain.schedule.Schedule;
import med.voll.api.domain.schedule.AppointmentSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class SchedulaController {

    @Autowired
    private AppointmentSchedule appointmentSchedule;

    @PostMapping
    @Transactional
    public ResponseEntity toSchedule(@RequestBody @Valid AppointmentSchedulingDTO data){
        System.out.println("Consulta: " + data);
        appointmentSchedule.toSchedule(data);
        return ResponseEntity.ok(new Schedule(null, null, null, null, null));
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity toCancel(@RequestBody @Valid CancelAppointmentScheduleDTO data){
        appointmentSchedule.cancel(data);
        return ResponseEntity.noContent().build();
    }

}