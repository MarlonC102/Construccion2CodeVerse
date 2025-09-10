package app.code.verse.domain.services;

import app.code.verse.domain.model.EmergencyContact;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmergencyContactPort;

public class RegisterEmergencyContact {
    private EmergencyContactPort emergencyContactPort;


    public void create(String patientIdNumber, EmergencyContact emergencyContact) {
        ValidateDataUtil.validateString(emergencyContact.getName(),"El nombre del contacto no puede estar vacío");
        ValidateDataUtil.validateString(emergencyContact.getKinship(),"La relación no puede estar vacía");
        ValidateDataUtil.validatePhoneSize(emergencyContact.getPhoneNumber());
        emergencyContactPort.register(patientIdNumber, emergencyContact);
    }
}
