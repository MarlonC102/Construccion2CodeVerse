package app.code.verse.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class EmergencyContactValidator extends SimpleValidator {

    public String kidnipValidator(String value) throws Exception {
        return stringValidator(value, "parentesco");
    }
}
