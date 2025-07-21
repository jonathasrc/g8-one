package med.voll.api.domain.patient;

public record PatientList(Long id,String nome, String email, String cpf) {
    public PatientList(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }

}
