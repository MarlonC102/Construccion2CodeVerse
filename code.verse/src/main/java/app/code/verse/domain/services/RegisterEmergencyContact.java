package app.code.verse.domain.services;

import app.code.verse.domain.model.EmergencyContact;
import app.code.verse.domain.ports.EmergencyContactPort;

public class RegisterEmergencyContact {
    private EmergencyContactPort emergencyContactPort;

    public RegisterEmergencyContact(EmergencyContactPort emergencyContactPort){
        this.emergencyContactPort = emergencyContactPort;
    }

    public void create(EmergencyContact emergencyContact, String patientIdNumber) throws Exception {
        if (emergencyContactPort.findByPatient(patientIdNumber) != null) {
            throw new IllegalArgumentException("El paciente ya tiene un contacto de emergencia registrado");
        }
        emergencyContactPort.register(patientIdNumber, emergencyContact);
    }
}
