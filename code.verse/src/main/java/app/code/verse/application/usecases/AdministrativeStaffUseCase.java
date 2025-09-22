package app.code.verse.application.usecases;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.ports.PatientPort;
import app.code.verse.domain.services.RegisterPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdministrativeStaffUseCase {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private RegisterPatient registerPatient;

    public void create(Patient patient) throws Exception {
        registerPatient.create(patient);
        //registerPolicy.create(patient.getIdNumber(), policy);
        //registerEmergencyContact.create(patient.getIdNumber(), emergencyContact);
    }

   /* public void createPolicy(Policy policy, Patient patient) throws Exception {
        registerPolicy.create(patient.getIdNumber(), policy);
    }

    public void createEmergencyContact(Patient patient, EmergencyContact emergencyContact) throws Exception {
        registerEmergencyContact.create(emergencyContact, patient.getIdNumber());
    }

    public Patient findById(String idNumber) {
        Patient patient = patientPort.findByIdNumber(idNumber);
        if (patient == null) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        return patient;
    }

    public Patient updatePatient(Patient patient) throws Exception {
        //if (findById(patient.getIdNumber()) != null) {
            patientPort.update(patient);
            return patient;
        //}
    }

    public void updatePolicy(String patientIdNumber, Policy policy) {
        policyPort.update(patientIdNumber, policy);
    }

    public void updateEmergencyContact(String patientIdNumber, EmergencyContact emergencyContact) {
        emergencyContactPort.update(patientIdNumber, emergencyContact);
    }

    public void deletePatient(Patient patient) throws Exception {
        if (findById(patient.getIdNumber()) != null) {
            patientPort.deleteById(patient);
            deletePolicy(patient.getIdNumber());
            deleteEmergencyContact(patient.getIdNumber());
        }
    }

    public void deletePolicy(String patientIdNumber) {
        if (policyPort.findByPatient(patientIdNumber) != null) {
            policyPort.delete(patientIdNumber);
        }
    }

    public void deleteEmergencyContact(String patientIdNumber) {
        if (emergencyContactPort.findByPatient(patientIdNumber) != null) {
            emergencyContactPort.delete(patientIdNumber);
        }
    }

*/
}