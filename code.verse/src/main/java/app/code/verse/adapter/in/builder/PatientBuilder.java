package app.code.verse.adapter.in.builder;

import app.code.verse.adapter.in.validators.PatientValidator;
import app.code.verse.adapter.in.validators.PersonValidator;
import app.code.verse.domain.model.Patient;

import java.time.LocalDate;

public class PatientBuilder {
    private PersonValidator personValidator;
    private PatientValidator patientValidator;

    public Patient build(String idNumber, String name, LocalDate birthDate, String gender, String address, String phoneNumber, String email) throws Exception {
        Patient patient = new Patient();
        patient.setIdNumber(personValidator.idNumberValidator(idNumber));
        patient.setName(personValidator.nameValidator(name));
        patient.setBirthDate(personValidator.birthDateValidator(birthDate));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(personValidator.addressValidator(address));
        patient.setPhoneNumber(personValidator.phoneNumberValidator(phoneNumber));
        patient.setEmail(personValidator.emailValidator(email));
        return patient;
    }
}
