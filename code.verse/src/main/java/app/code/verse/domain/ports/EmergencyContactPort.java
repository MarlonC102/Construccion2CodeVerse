package app.code.verse.domain.ports;

import app.code.verse.domain.model.EmergencyContact;

public interface EmergencyContactPort {
    void register(String patientIdNumber, EmergencyContact contact);
    void update(String patientIdNumber, EmergencyContact contact);
    EmergencyContact findByPatient(String patientIdNumber);
    void delete(String patientIdNumber);
}
