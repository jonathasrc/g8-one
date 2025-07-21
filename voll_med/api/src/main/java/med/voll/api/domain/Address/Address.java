package med.voll.api.domain.Address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String public_place;
    private String neighborhood;
    private String zipCode;
    private String number;
    private String city;
    private String uf;
    private String complement;

    public Address(AddressDTO dtoAddress) {
        this.public_place = dtoAddress.logradouro();
        this.complement = dtoAddress.complemento();
        this.uf = dtoAddress.uf();
        this.city = dtoAddress.cidade();
        this.number = dtoAddress.numero();
        this.zipCode = dtoAddress.cep();
        this.neighborhood = dtoAddress.bairro();
    }

    public void updateInfo(AddressDTO data) {
        if (data.logradouro() != null) {
            this.public_place = data.logradouro();
        }
        if (data.complemento() != null) {
            this.complement = data.complemento();
        }
        if (data.uf() != null) {
            this.uf = data.uf();
        }
        if (data.cidade() != null) {
            this.city = data.cidade();
        }
        if (data.numero() != null) {
            this.number = data.numero();
        }
        if (data.cep() != null) {
            this.zipCode = data.cep();
        }
        if (data.bairro() != null) {
            this.neighborhood = data.bairro();
        }

    }

}
