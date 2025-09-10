package app.code.verse.application.usecases;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.PatientPort;

public class UpdatePatient {
    private FindPatient findPatient;
    private PatientPort patientPort;

    public void update(Patient patient) throws Exception {
        if (findPatient.existsById(patient)) {
            ValidateDataUtil.validateString(patient.getName(), "El nombre del paciente no puede estar vacío");
            ValidateDataUtil.validateString(patient.getAddress(), "La dirección no puede estar vacía");
            ValidateDataUtil.validateString(patient.getGender(), "El género no puede estar vacío");
            ValidateDataUtil.validateLocalDate(patient.getBirthDate(), "La fecha de nacimiento  no puede estar vacía");
            ValidateDataUtil.validateMaximumSize(patient.getEmail(), "correo electrónico", 50);
            ValidateDataUtil.validateMaximumSize(patient.getPhoneNumber(), "número de teléfono", 10);
            ValidateDataUtil.validateMinimumSize(patient.getPhoneNumber(), "número de teléfono", 10);
            if (patient.getEmail() != null) {
                ValidateDataUtil.validateEmail(patient.getEmail(), "El correo electrónico debe tener un formato válido");
            }
            patientPort.update(patient);
        }
    }
}
