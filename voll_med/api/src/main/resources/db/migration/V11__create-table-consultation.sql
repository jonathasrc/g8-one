create table consultations
(
    id       bigint       not null auto_increment,
    medical_id    bigint not null,
    patient_id bigint not null,
    data datetime not null ,

    primary key (id),
    constraint fk_consultation_medical_id foreign key (medical_id) references medical(id),
    constraint fk_consultation_patient_id foreign key (patient_id) references patient(id)
);