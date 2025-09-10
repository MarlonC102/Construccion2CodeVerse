package app.code.verse.domain.ports;

import app.code.verse.domain.model.Patient;

public interface PatientPort {
    void save(Patient patient) throws Exception;
    void delete(Patient patient) throws Exception;
    void update(Patient patient) throws Exception;
    Patient findByIdNumber(String idNumber);
}
