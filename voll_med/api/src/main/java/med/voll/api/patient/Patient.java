package med.voll.api.patient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Address.Address;

@Table(name = "patient")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String cpf;

    @Embedded
    private Address address;
    private Boolean active;

    public Patient(PatientDTO patientDTO) {
        this.name = patientDTO.nome();
        this.email = patientDTO.email();
        this.telephone = patientDTO.telefone();
        this.cpf = patientDTO.cpf();
        this.address = new Address(patientDTO.endereco());
    }

    public void updateInfo(PatientUpdate data) {

        if (data.nome() != null) {
            this.name = data.nome();
        }
        if (data.telefone() != null) {
            this.telephone = data.telefone();
        }

        if (data.endereco() != null) {
            this.address.updateInfo(data.endereco());
        }




    }

    public void delete() {
        this.active = false;
    }
}
