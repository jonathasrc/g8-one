package med.voll.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Address.AddressDTO;

public record PatientUpdate(
        @NotNull
        Long id,
        String nome,
        String telefone,
        AddressDTO endereco

) {
}
