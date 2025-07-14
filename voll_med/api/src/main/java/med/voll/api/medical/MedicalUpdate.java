package med.voll.api.medical;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Address.Address;
import med.voll.api.Address.AddressDTO;

public record MedicalUpdate(@NotNull Long id, String nome, String telefone, AddressDTO endereco) {

}
