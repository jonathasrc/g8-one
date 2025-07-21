package med.voll.api.domain.medical;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.Address.Address;

@Table(name = "medical")
@Entity(name = "medical")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medical {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String crm;
    private Boolean active;


    @Enumerated(EnumType.STRING)
    private SpecialityMedical speciality;

    @Embedded
    private Address address;

    public Medical(MedicalDTO dto) {
        this.active = true;
        this.address = new Address(dto.endereco());
        this.name = dto.nome();
        this.phoneNumber = dto.telefone();
        this.email = dto.email();
        this.speciality = dto.especialidade();
        this.crm = dto.crm();
    }

    public void updateInfo(MedicalUpdate dtoUpdate){
        if (dtoUpdate.nome() != null) {
            this.name = dtoUpdate.nome();
        }
        if (dtoUpdate.telefone() != null) {
            this.phoneNumber = dtoUpdate.telefone();
        }
        if (dtoUpdate.endereco() != null) {
            this.address.updateInfo(dtoUpdate.endereco());
        }
    }

    public void     excluir() {
        this.active = false;
    }
}
