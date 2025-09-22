package app.code.verse.adapter.in.builder;

import app.code.verse.adapter.in.validators.PatientValidator;
import app.code.verse.adapter.in.validators.PersonValidator;
import app.code.verse.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PatientBuilder {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
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
        patient.setStatus(true);
        return patient;
    }
}
