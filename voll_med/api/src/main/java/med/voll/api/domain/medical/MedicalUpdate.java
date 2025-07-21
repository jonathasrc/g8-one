package med.voll.api.domain.medical;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Address.AddressDTO;

public record MedicalUpdate(@NotNull Long id, String nome, String telefone, AddressDTO endereco) {

}
