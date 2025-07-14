package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public void registerPatient(@RequestBody @Valid PatientDTO dto) {
        patientRepository.save(new Patient(dto));

    }

   @GetMapping
    public Page<PatientList> getPatients(Pageable pageable) {
       return patientRepository.findAllByActiveTrue(pageable).map(PatientList::new);
    }

    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid PatientUpdate dto) {
        var patient = patientRepository.getReferenceById(dto.id());
        System.out.println(patient);
        patient.updateInfo(dto);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        System.out.println(patient);
        patient.delete();
    }

}
