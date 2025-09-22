package app.code.verse.domain.ports;

import app.code.verse.domain.model.Patient;

import java.util.List;

public interface PatientPort{
    Patient create(Patient patient) throws Exception;
    void deleteById(Patient patient) throws Exception;
    void update(Patient patient) throws Exception;
    Patient findByIdNumber(String idNumber);
    List<Patient> findAll();
}
