package app.code.verse.domain.services;

import app.code.verse.domain.model.Policy;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.PolicyPort;

public class RegisterPolicy {
    private PolicyPort policyPort;


    public void create(String patientIdNumber, Policy policy) {
        ValidateDataUtil.validateString(policy.getCompanyName(), "El nombre de la compañía de seguros no puede estar vacío");
        ValidateDataUtil.validateString(policy.getPolicyNumber(), "El número de poliza no puede estar vacío");
        ValidateDataUtil.validateLocalDate(policy.getExpirationDate(), "La fecha de expiración de la póliza no puede estar vacía");
        policyPort.register(patientIdNumber, policy);
    }
}
