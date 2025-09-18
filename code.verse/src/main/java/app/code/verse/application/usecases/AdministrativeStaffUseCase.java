package app.code.verse.application.usecases;

import app.code.verse.domain.model.EmergencyContact;
import app.code.verse.domain.model.Patient;
import app.code.verse.domain.model.Policy;
import app.code.verse.domain.ports.EmergencyContactPort;
import app.code.verse.domain.ports.PatientPort;
import app.code.verse.domain.ports.PolicyPort;
import app.code.verse.domain.services.RegisterEmergencyContact;
import app.code.verse.domain.services.RegisterPatient;
import app.code.verse.domain.services.RegisterPolicy;

public class AdministrativeStaffUseCase {
    private RegisterPatient registerPatient;
    private RegisterEmergencyContact registerEmergencyContact;
    private RegisterPolicy registerPolicy;
    private PatientPort patientPort;
    private PolicyPort policyPort;
    private EmergencyContactPort emergencyContactPort;

    public void createPatient(Patient patient, EmergencyContact emergencyContact, Policy policy) throws Exception {
        registerPatient.create(patient);
    }

    public void createPolicy(Policy policy, Patient patient) throws Exception {
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

    public void updatePatient(Patient patient) throws Exception {
        if (findById(patient.getIdNumber()) != null) {
            patientPort.update(patient);
        }
    }

    public void updatePolicy(String patientIdNumber, Policy policy) {
        policyPort.update(patientIdNumber, policy);
    }

    public void updateEmergencyContact(String patientIdNumber, EmergencyContact emergencyContact) {
        emergencyContactPort.update(patientIdNumber, emergencyContact);
    }

    public void deletePatient(Patient patient) throws Exception {
        if (findById(patient.getIdNumber()) != null) {
            patientPort.delete(patient);
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


}