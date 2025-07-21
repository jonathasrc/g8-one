package med.voll.api.domain.patient;

import med.voll.api.domain.Address.Address;

public record PatientDetails(
        Long id,
        String name,
        Address address


) {
    public PatientDetails(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getAddress());
    }
}
