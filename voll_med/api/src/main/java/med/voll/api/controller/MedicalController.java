package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medical.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicalController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerMedical(@RequestBody @Valid MedicalDTO data, UriComponentsBuilder uriBuilder) {
        var medical = new Medical(data);
        medicalRepository.save(medical);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medical.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicalDetails(medical));
    }

    @GetMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity getMedical(@PathVariable Long id) {
        var medical = medicalRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicalDetails(medical));
    }

    @GetMapping
    public ResponseEntity<Page<MedicalList>> listMedicals(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable, Sort sort) {
        var page =  medicalRepository.findAllByActiveTrue(pageable).map(MedicalList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateMedical(@RequestBody @Valid MedicalUpdate data) {
        var medical = medicalRepository.getReferenceById(data.id());
        medical.updateInfo(data);

        return ResponseEntity.ok(new MedicalDetails(medical));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedical(@PathVariable Long id) {
        var medical = medicalRepository.getReferenceById(id);
        medical.excluir();

        return ResponseEntity.noContent().build();
    }
}
