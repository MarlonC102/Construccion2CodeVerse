package app.code.verse.domain.services;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.ports.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPatient {
    @Autowired
    private PatientPort patientPort;

    public RegisterPatient(PatientPort patientPort){
        this.patientPort = patientPort;
    }

    public void create(Patient patient) throws Exception {
        //checkIfPatientExists(patient);
        patientPort.create(patient);
    }

    private void checkIfPatientExists(Patient patient) throws Exception {
        if (patientPort.findByIdNumber(patient.getIdNumber()) != null) {
            throw new IllegalArgumentException("El paciente ya existe");
        }
    }
}
