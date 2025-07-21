package med.voll.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.Address.AddressDTO;

public record PatientDTO(
        @NotBlank
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String telefone,
        @NotNull
        @Pattern(regexp ="\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}" )
        String cpf,
        @Valid
        AddressDTO endereco

) {
}
