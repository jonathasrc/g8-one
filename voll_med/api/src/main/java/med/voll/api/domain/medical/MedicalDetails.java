package med.voll.api.domain.medical;

import med.voll.api.domain.Address.Address;

public record MedicalDetails(Long id,
                             String name,
                             String email,
                             String crm,
                             String phone_number,
                             SpecialityMedical speciality, Address endereco) {
    public MedicalDetails(Medical medical) {
        this(medical.getId(), medical.getName(), medical.getEmail(), medical.getCrm(),medical.getPhoneNumber(), medical.getSpeciality(), medical.getAddress());
    }

}
