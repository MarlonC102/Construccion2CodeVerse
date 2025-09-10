package app.code.verse.application.usecases;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.PatientPort;

public class DeletePatient {
    PatientPort patientPort;
    FindPatient findPatient;
    public void delete(Patient patient) throws Exception {
        ValidateDataUtil.validateString(patient.getIdNumber(), "El número de identificación no puede estar vacío");
        if (findPatient.existsById(patient)){
            patientPort.delete(patient);
        }


    }
}
