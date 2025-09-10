package app.code.verse.domain.services;

import app.code.verse.application.usecases.FindPatient;
import app.code.verse.domain.model.Patient;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.PatientPort;

public class RegisterPatient {
    private FindPatient findPatient;
    private PatientPort patientPort;

    public void create(Patient patient) throws Exception {
        ValidateDataUtil.validateString(patient.getName(), "El nombre del paciente no puede estar vacío");
        ValidateDataUtil.validateString(patient.getIdNumber(), "El número de identificación no puede estar vacío");
        ValidateDataUtil.validateString(patient.getAddress(), "La dirección no puede estar vacía");
        ValidateDataUtil.validateString(patient.getGender(), "El género no puede estar vacío");
        ValidateDataUtil.validateLocalDate(patient.getBirthDate(), "La fecha de nacimiento  no puede estar vacía");
        ValidateDataUtil.validateMaximumSize(patient.getIdNumber(), "número de identificación", 10);
        ValidateDataUtil.validateMaximumSize(patient.getEmail(), "correo electrónico", 50);
        ValidateDataUtil.validateMaximumSize(patient.getPhoneNumber(), "número de teléfono", 10);
        ValidateDataUtil.validateMinimumSize(patient.getPhoneNumber(), "número de teléfono", 10);
        if (patient.getEmail() != null) {
            ValidateDataUtil.validateEmail(patient.getEmail(), "El correo electrónico debe tener un formato válido");
        }
        if (findPatient.existsById(patient)) {
            throw new IllegalArgumentException("El paciente ya existe");
        }
        patientPort.save(patient);
    }
}
