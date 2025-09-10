package app.code.verse.application.usecases;


import app.code.verse.domain.model.Patient;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.PatientPort;
import app.code.verse.domain.ports.PersonPort;

public class FindPatient {
    private PersonPort personPort;
    private PatientPort patientPort;

    public boolean existsById(Patient patient) {
        ValidateDataUtil.validateString(patient.getIdNumber(), "El número de identificación no puede estar vacío");
        return personPort.existsByIdNumber(patient.getIdNumber());
    }

    public Patient findById(String idNumber) {
        ValidateDataUtil.validateString(idNumber,
                "El número de identificación no puede ser nulo o vacío");
        Patient patient = patientPort.findByIdNumber(idNumber);
        if (patient == null) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        return patient;
    }
}
