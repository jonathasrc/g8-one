package med.voll.api.domain.schedule;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import med.voll.api.domain.ValidationScheduleException;
import med.voll.api.domain.medical.Medical;
import med.voll.api.domain.medical.MedicalRepository;
import med.voll.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;

@Service
public class AppointmentSchedule {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private MedicalRepository medicalRepository;
    @Autowired
    private PatientRepository patientRepository;

    public void toSchedule(AppointmentSchedulingDTO data){

        if (!patientRepository.existsById(data.idPatient())){
           throw new ValidationScheduleException("Id do patient not exists");
        }

        if (data.idMedico() != null && !medicalRepository.existsById(data.idMedico())){
            throw new ValidationScheduleException("Id do medico not exists");
        }

        var patient = patientRepository.findById(data.idPatient()).get();
        var medical = chooseMedical(data);
        var schedule = new Schedule(null, medical, patient, data.date(), null);

        scheduleRepository.save(schedule);


     }

    private Medical chooseMedical(AppointmentSchedulingDTO data) {
        if (data.idMedico() != null){
            return medicalRepository.getReferenceById(data.idMedico());
        }

        if (data.speciality() != null){
            throw new ValidationScheduleException ("Specialty is not mandatory when the doctor is not chosen");
        }

        return medicalRepository.chooseRandomDoctorOnDate(data.speciality(), data.date());


    }


    public void cancel(@Valid CancelAppointmentScheduleDTO data) {
        if (!scheduleRepository.existsById(data.idConsulta())){
            throw new ValidationScheduleException("Consulta do patient not exists");
        }
        var schedule = scheduleRepository.getReferenceById(data.idConsulta());
        schedule.cancel(data.reason());
    }
}