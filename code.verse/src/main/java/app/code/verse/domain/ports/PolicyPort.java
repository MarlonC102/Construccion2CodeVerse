package app.code.verse.domain.ports;

import app.code.verse.domain.model.Policy;

public interface PolicyPort {
    void register(String patientIdNumber, Policy policy);
    void update(String patientIdNumber, Policy policy);
    Policy findByPatient(String patientIdNumber);
    void delete(String patientIdNumber);
}
