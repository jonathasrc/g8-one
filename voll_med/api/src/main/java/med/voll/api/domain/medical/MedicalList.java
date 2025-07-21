package med.voll.api.domain.medical;

public record MedicalList(Long id, String nome, String email, String crm, SpecialityMedical especialidade ) {

    public MedicalList (Medical medical) {
        this(medical.getId(), medical.getName(), medical.getEmail(), medical.getCrm(), medical.getSpeciality());
    }

}
