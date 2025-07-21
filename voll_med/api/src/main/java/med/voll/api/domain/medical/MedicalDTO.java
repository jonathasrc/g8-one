package med.voll.api.domain.medical;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.Address.AddressDTO;

public record MedicalDTO(
        @NotBlank

        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        SpecialityMedical especialidade,
        @NotNull
        @Valid
        AddressDTO endereco) {
}
