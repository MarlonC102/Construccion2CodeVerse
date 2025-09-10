package app.code.verse.application.usecases;

import app.code.verse.domain.model.EmergencyContact;
import app.code.verse.domain.ports.EmergencyContactPort;

public class FindEmergencyContact {
    private EmergencyContactPort emergencyContactPort;


    public EmergencyContact findById(String patientIdNumber) {
        return emergencyContactPort.findByPatient(patientIdNumber);
    }
}
