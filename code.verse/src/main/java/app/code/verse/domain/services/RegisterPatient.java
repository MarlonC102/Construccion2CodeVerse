package app.code.verse.domain.services;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.ports.PatientPort;
import app.code.verse.domain.ports.PersonPort;

;

public class RegisterPatient {
    private PersonPort personPort;
    private PatientPort patientPort;

    public RegisterPatient(PersonPort personPort, PatientPort patientPort){
        this.personPort = personPort;
        this.patientPort = patientPort;
    }

    public void create(Patient patient) throws Exception {
        checkIfPatientExists(patient);
        patientPort.save(patient);
    }

    private void checkIfPatientExists(Patient patient) throws Exception {
        if (personPort.existsByIdNumber(patient.getIdNumber())) {
            throw new IllegalArgumentException("El paciente ya existe");
        }
    }
}
