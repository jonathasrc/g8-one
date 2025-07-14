package med.voll.api.patient;

import med.voll.api.medical.Medical;

public record PatientList(Long id,String nome, String email, String cpf) {
    public PatientList(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }

}
