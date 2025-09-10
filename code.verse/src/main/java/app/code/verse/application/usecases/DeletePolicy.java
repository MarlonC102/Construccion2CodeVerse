package app.code.verse.application.usecases;

import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.PolicyPort;

public class DeletePolicy {
    private PolicyPort policyPort;
    private FindPolicy findPolicy;

    public void delete(String patientIdNumber) {
        ValidateDataUtil.validateString(patientIdNumber, "El número de identificación no puede estar vacío");
        if (findPolicy.findById(patientIdNumber) != null) {
            policyPort.delete(patientIdNumber);
        }
    }
}
