package app.code.verse.infrastructure.persistence.mapper;

import app.code.verse.domain.model.Patient;
import app.code.verse.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    public static PatientEntity toEntity(Patient patient) {
        if (patient == null) return null;
        PatientEntity entity = new PatientEntity();
        entity.setId(null);
        entity.setName(patient.getName());
        entity.setIdNumber(patient.getIdNumber());
        entity.setEmail(patient.getEmail());
        entity.setPhoneNumber(patient.getPhoneNumber());
        entity.setBirthDate(patient.getBirthDate());
        entity.setAddress(patient.getAddress());
        entity.setGender(patient.getGender());
        entity.setStatus(true);
        return entity;
    }

    public static Patient toDomain(PatientEntity patientEntity) {
        if (patientEntity == null) return null;
        Patient patient = new Patient();
        patient.setId(patientEntity.getId());
        patient.setName(patientEntity.getName());
        patient.setIdNumber(patientEntity.getIdNumber());
        patient.setEmail(patientEntity.getEmail());
        patient.setPhoneNumber(patientEntity.getPhoneNumber());
        patient.setBirthDate(patientEntity.getBirthDate());
        patient.setAddress(patientEntity.getAddress());
        return patient;
    }
}
