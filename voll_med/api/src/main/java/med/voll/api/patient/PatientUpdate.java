package med.voll.api.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.Address.AddressDTO;

public record PatientUpdate(
        @NotNull
        Long id,
        String nome,
        String telefone,
        AddressDTO endereco

) {
}
