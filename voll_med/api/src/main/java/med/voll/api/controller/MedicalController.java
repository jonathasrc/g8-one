package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medical.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicalController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public void registerMedical(@RequestBody @Valid MedicalDTO dto) {
        medicalRepository.save(new Medical(dto));
    }

    @GetMapping
    public Page<MedicalList> listMedicals(@PageableDefault(size=10, sort = {"name"}) Pageable pageable, Sort sort) {
        return medicalRepository.findAllByActiveTrue(pageable).map(MedicalList::new);
    }

    @PutMapping
    @Transactional
    public void updateMedical(@RequestBody @Valid MedicalUpdate dto) {
        var medical = medicalRepository.getReferenceById(dto.id());
        medical.updateInfo(dto);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedical(@PathVariable Long id) {
        var medical = medicalRepository.getReferenceById(id);
        medical.excluir();
    }
}
