package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerPatient(@RequestBody @Valid PatientDTO data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        patientRepository.save(patient);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(patient.getId()).toUri();



        return ResponseEntity.created(uri).body(new PatientDetails(patient));
    }
    @GetMapping("/{id}")
    public ResponseEntity getPatient(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetails(patient));
    }

   @GetMapping
    public ResponseEntity<Page<PatientList>> getPatients(Pageable pageable) {
       var page =  patientRepository.findAllByActiveTrue(pageable).map(PatientList::new);
       return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdate data) {
        var patient = patientRepository.getReferenceById(data.id());
        patient.updateInfo(data);

        return ResponseEntity.ok(new PatientDetails(patient));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.delete();

       return ResponseEntity.noContent().build();
    }

}
