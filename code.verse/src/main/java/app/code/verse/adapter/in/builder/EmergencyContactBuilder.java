package app.code.verse.adapter.in.builder;

import app.code.verse.adapter.in.validators.EmergencyContactValidator;
import app.code.verse.adapter.in.validators.PersonValidator;
import app.code.verse.domain.model.EmergencyContact;

public class EmergencyContactBuilder {
    private EmergencyContactValidator emergencyContactValidator;
    private PersonValidator personValidator;

    public EmergencyContact buil(String name, String kinship, String phoneNumber) throws Exception {
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(personValidator.nameValidator(name));
        emergencyContact.setKinship(emergencyContactValidator.kidnipValidator(kinship));
        emergencyContact.setPhoneNumber(personValidator.phoneNumberValidator(phoneNumber));
        return emergencyContact;
    }

}
