package app.code.verse.application.usecases;

import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmergencyContactPort;

public class DeleteEmergencyContact {
    private EmergencyContactPort emergencyContactPort;
    private FindEmergencyContact findEmergencyContact;


    public void delete(String patientIdNumber) {
        ValidateDataUtil.validateString(patientIdNumber, "El número de identificación no puede estar vacío");
        if (findEmergencyContact.findById(patientIdNumber) != null) {
            emergencyContactPort.delete(patientIdNumber);
        }

    }
}
